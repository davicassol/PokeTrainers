package com.example.ap2_kotlin.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.ap2_kotlin.data.repository.PersonagensRepository

class PersonagemViewModelFactory(private val repository: PersonagensRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PersonagemViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return PersonagemViewModel(repository) as T
        }
        throw IllegalArgumentException("Classe ViewModel desconhecida")
    }
}