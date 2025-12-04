package com.example.ap2_kotlin.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.ap2_kotlin.data.entity.PersonagensPoke

@Dao
interface PersonagemDao {

    @Query("SELECT * FROM personagens_table ORDER BY nome ASC")
    fun listarTodos(): LiveData<List<PersonagensPoke>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun inserir(personagem: PersonagensPoke)

    @Update
    suspend fun atualizar(personagem: PersonagensPoke)

    @Delete
    suspend fun deletar(personagem: PersonagensPoke)

    @Query("SELECT * FROM personagens_table WHERE id = :id")
    fun buscarPorId(id: Int): LiveData<PersonagensPoke>
}