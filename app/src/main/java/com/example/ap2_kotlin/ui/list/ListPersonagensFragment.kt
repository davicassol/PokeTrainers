package com.example.ap2_kotlin.ui.list

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ap2_kotlin.R
import com.example.ap2_kotlin.data.database.AppDatabase
import com.example.ap2_kotlin.data.entity.PersonagensPoke
import com.example.ap2_kotlin.data.repository.PersonagensRepository
import com.example.ap2_kotlin.databinding.FragmentListPersonagensBinding
import com.example.ap2_kotlin.ui.adapter.PersonagensAdapter // Verifique se o import do Adapter está correto
import com.example.ap2_kotlin.ui.viewmodel.PersonagemViewModel
import com.example.ap2_kotlin.ui.viewmodel.PersonagemViewModelFactory

class ListPersonagensFragment : Fragment() {

    private var _binding: FragmentListPersonagensBinding? = null
    private val binding get() = _binding!!

    // Inicializa o ViewModel
    private val viewModel: PersonagemViewModel by viewModels {
        val database = AppDatabase.getDatabase(requireContext())
        val repository = PersonagensRepository(database.personagemDao())
        PersonagemViewModelFactory(repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListPersonagensBinding.inflate(inflater, container, false)

        val adapter = PersonagensAdapter(
            onClick = { personagem ->
                val bundle = Bundle().apply {
                    putSerializable("personagem", personagem)
                }
                findNavController().navigate(R.id.action_list_to_details, bundle)
            },
            onLongClick = { personagem ->
                mostrarDialogoExclusao(personagem)
            }
        )

        binding.rvPersonagens.adapter = adapter
        binding.rvPersonagens.layoutManager = LinearLayoutManager(requireContext())

        viewModel.todosPersonagens.observe(viewLifecycleOwner) { lista ->
            adapter.atualizarLista(lista)
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_list_to_form)
        }

        return binding.root
    }

    private fun mostrarDialogoExclusao(personagem: PersonagensPoke) {
        AlertDialog.Builder(requireContext())
            .setTitle("Excluir Personagem")
            .setMessage("Tem certeza que deseja apagar ${personagem.nome}?")
            .setPositiveButton("Sim") { _, _ ->
                viewModel.deletar(personagem)
                Toast.makeText(requireContext(), "${personagem.nome} apagado!", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Não", null)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}