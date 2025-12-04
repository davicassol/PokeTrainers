package com.example.ap2_kotlin.data.repository

import androidx.lifecycle.LiveData
import com.example.ap2_kotlin.data.dao.PersonagemDao
import com.example.ap2_kotlin.data.entity.PersonagensPoke

class PersonagensRepository(private val personagemDao: PersonagemDao) {

    // Esta variável pega a lista direto do banco de dados
    val listaTodosPersonagens: LiveData<List<PersonagensPoke>> = personagemDao.listarTodos()

    suspend fun inserir(personagem: PersonagensPoke) {
        personagemDao.inserir(personagem)
    }

    suspend fun atualizar(personagem: PersonagensPoke) {
        personagemDao.atualizar(personagem)
    }

    suspend fun deletar(personagem: PersonagensPoke) {
        personagemDao.deletar(personagem)
    }

    fun buscarPorId(id: Int): LiveData<PersonagensPoke> {
        return personagemDao.buscarPorId(id)
    }
}