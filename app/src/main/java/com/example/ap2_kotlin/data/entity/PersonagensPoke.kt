package com.example.ap2_kotlin.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "personagens_table")
data class PersonagensPoke(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nome: String,
    val tipo: String,
    val regiao: String,
    val idade: Int,
    val pokemonPrincipal: String,
    val descricao: String
) : Serializable