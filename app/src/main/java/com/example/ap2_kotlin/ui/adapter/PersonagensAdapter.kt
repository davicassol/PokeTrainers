package com.example.ap2_kotlin.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ap2_kotlin.R
import com.example.ap2_kotlin.data.PersonagensPoke
import com.example.ap2_kotlin.data.PersonagensRepository
import android.content.Intent
import com.example.ap2_kotlin.ui.activity.DetalhesActivity


class PersonagensAdapter : RecyclerView.Adapter<PersonagensAdapter.PersonagemViewHolder>() {

    private val personagens = PersonagensRepository.listaPersonagensPoke

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

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context

            val intent = Intent(context, DetalhesActivity::class.java)

            intent.putExtra(DetalhesActivity.EXTRA_PERSONAGEM, personagem)

            context.startActivity(intent)
        }


        holder.itemView.setOnLongClickListener {
            val currentPosition = holder.adapterPosition
            if (currentPosition != RecyclerView.NO_POSITION) {
                personagens.removeAt(currentPosition)
                notifyItemRemoved(currentPosition)
                notifyItemRangeChanged(currentPosition, personagens.size)
            }
            true
        }
    }
}