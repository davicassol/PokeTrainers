package com.example.ap2_kotlin.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap2_kotlin.R
import com.example.ap2_kotlin.data.entity.PersonagensPoke

class PersonagensAdapter(
    private val onClick: (PersonagensPoke) -> Unit,
    private val onLongClick: (PersonagensPoke) -> Unit
) : RecyclerView.Adapter<PersonagensAdapter.PersonagemViewHolder>() {

    private var personagens = mutableListOf<PersonagensPoke>()

    fun atualizarLista(novaLista: List<PersonagensPoke>) {
        personagens = novaLista.toMutableList()
        notifyDataSetChanged()
    }

    class PersonagemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nomePersonagem: TextView = view.findViewById(R.id.tv_nome_personagem)
        val tipoPersonagem: TextView = view.findViewById(R.id.tv_tipo_personagem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonagemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_personagem, parent, false)
        return PersonagemViewHolder(view)
    }

    override fun getItemCount() = personagens.size

    override fun onBindViewHolder(holder: PersonagemViewHolder, position: Int) {
        val personagem = personagens[position]
        holder.nomePersonagem.text = personagem.nome
        holder.tipoPersonagem.text = personagem.tipo

        // Clique Normal -> Chama a função de Detalhes
        holder.itemView.setOnClickListener {
            onClick(personagem)
        }

        // Clique Longo -> Chama a função de Deletar
        holder.itemView.setOnLongClickListener {
            onLongClick(personagem)
            true
        }
    }
}