package com.example.ap2_kotlin.ui.details

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ap2_kotlin.R
import com.example.ap2_kotlin.data.database.AppDatabase
import com.example.ap2_kotlin.data.entity.PersonagensPoke
import com.example.ap2_kotlin.data.repository.PersonagensRepository
import com.example.ap2_kotlin.databinding.FragmentDetalhesPersonagemBinding
import com.example.ap2_kotlin.ui.viewmodel.PersonagemViewModel
import com.example.ap2_kotlin.ui.viewmodel.PersonagemViewModelFactory

class DetalhesPersonagemFragment : Fragment() {

    private var _binding: FragmentDetalhesPersonagemBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PersonagemViewModel by viewModels {
        val database = AppDatabase.getDatabase(requireContext())
        val repository = PersonagensRepository(database.personagemDao())
        PersonagemViewModelFactory(repository)
    }

    private var personagemAtual: PersonagensPoke? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetalhesPersonagemBinding.inflate(inflater, container, false)

        val argumento = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("personagem", PersonagensPoke::class.java)
        } else {
            arguments?.getSerializable("personagem") as? PersonagensPoke
        }
        argumento?.let { tempPersonagem ->
            viewModel.buscarPorId(tempPersonagem.id).observe(viewLifecycleOwner) { personagemDoBanco ->
                personagemAtual = personagemDoBanco
                // Atualiza a UI com os dados do personagem
                personagemDoBanco?.let { p ->
                    binding.tvNomeDetalhe.text = p.nome
                    binding.tvTipoDetalhe.text = "Tipo: ${p.tipo}"
                    binding.tvRegiaoDetalhe.text = "Região: ${p.regiao}"
                    binding.tvIdadeDetalhe.text = "Idade: ${p.idade}"
                    binding.tvPokemonDetalhe.text = p.pokemonPrincipal
                    binding.tvDescricaoDetalhe.text = p.descricao
                }
            }
        }

        binding.fabEdit.setOnClickListener {
            // Navega para o formulário com o personagem atual
            personagemAtual?.let { p ->
                val bundle = Bundle().apply {
                    putSerializable("personagem", p)
                }
                findNavController().navigate(R.id.action_details_to_form, bundle)
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}