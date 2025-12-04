package com.example.ap2_kotlin.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ap2_kotlin.data.entity.PersonagensPoke
import com.example.ap2_kotlin.data.repository.PersonagensRepository
import kotlinx.coroutines.launch

class PersonagemViewModel(private val repository: PersonagensRepository) : ViewModel() {

    val todosPersonagens: LiveData<List<PersonagensPoke>> = repository.listaTodosPersonagens

    fun inserir(personagem: PersonagensPoke) = viewModelScope.launch {
        repository.inserir(personagem)
    }

    fun atualizar(personagem: PersonagensPoke) = viewModelScope.launch {
        repository.atualizar(personagem)
    }

    fun deletar(personagem: PersonagensPoke) = viewModelScope.launch {
        repository.deletar(personagem)
    }

    fun buscarPorId(id: Int): LiveData<PersonagensPoke> {
        return repository.buscarPorId(id)
    }
}