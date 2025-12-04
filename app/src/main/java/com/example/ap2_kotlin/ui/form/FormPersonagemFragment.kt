package com.example.ap2_kotlin.ui.form

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.ap2_kotlin.data.database.AppDatabase
import com.example.ap2_kotlin.data.entity.PersonagensPoke
import com.example.ap2_kotlin.data.repository.PersonagensRepository
import com.example.ap2_kotlin.databinding.FragmentFormPersonagemBinding
import com.example.ap2_kotlin.ui.viewmodel.PersonagemViewModel
import com.example.ap2_kotlin.ui.viewmodel.PersonagemViewModelFactory

class FormPersonagemFragment : Fragment() {

    private var _binding: FragmentFormPersonagemBinding? = null
    private val binding get() = _binding!!
    private var personagemParaEditar: PersonagensPoke? = null

    private val viewModel: PersonagemViewModel by viewModels {
        val database = AppDatabase.getDatabase(requireContext())
        val repository = PersonagensRepository(database.personagemDao())
        PersonagemViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFormPersonagemBinding.inflate(inflater, container, false)

        personagemParaEditar = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getSerializable("personagem", PersonagensPoke::class.java)
        } else {
            arguments?.getSerializable("personagem") as? PersonagensPoke
        }

        if (personagemParaEditar != null) {
            binding.etNome.setText(personagemParaEditar?.nome)
            binding.etTipo.setText(personagemParaEditar?.tipo)
            binding.etRegiao.setText(personagemParaEditar?.regiao)
            binding.etIdade.setText(personagemParaEditar?.idade.toString())
            binding.etPokemon.setText(personagemParaEditar?.pokemonPrincipal)
            binding.etDescricao.setText(personagemParaEditar?.descricao)
            binding.btnSalvar.text = "Atualizar"
        }

        binding.btnSalvar.setOnClickListener {
            salvarOuAtualizar()
        }

        return binding.root
    }

    private fun salvarOuAtualizar() {
        val nome = binding.etNome.text.toString()
        val tipo = binding.etTipo.text.toString()
        val regiao = binding.etRegiao.text.toString()
        val idadeStr = binding.etIdade.text.toString()
        val pokemon = binding.etPokemon.text.toString()
        val descricao = binding.etDescricao.text.toString()

        if (nome.isNotEmpty() && tipo.isNotEmpty()) {
            val idade = idadeStr.toIntOrNull() ?: 0

            val personagemFinal = PersonagensPoke(
                id = personagemParaEditar?.id ?: 0,
                nome = nome,
                tipo = tipo,
                regiao = regiao,
                idade = idade,
                pokemonPrincipal = pokemon,
                descricao = descricao
            )

            if (personagemParaEditar == null) {
                viewModel.inserir(personagemFinal)
                Toast.makeText(context, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.atualizar(personagemFinal)
                Toast.makeText(context, "Atualizado com sucesso!", Toast.LENGTH_SHORT).show()
            }

            findNavController().popBackStack()

        } else {
            Toast.makeText(context, "Preencha Nome e Tipo", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}