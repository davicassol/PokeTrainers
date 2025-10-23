package com.example.ap2_kotlin.data

import java.io.Serializable

data class PersonagensPoke(
    val id: Int,
    val nome: String,
    val tipo: String,
    val regiao: String,
    val idade: Int,
    val pokemonPrincipal: String,
    val descricao: String
): Serializable
