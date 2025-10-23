package com.example.ap2_kotlin.ui.activity

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.ap2_kotlin.R
import com.example.ap2_kotlin.data.PersonagensPoke

class DetalhesActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSONAGEM = "EXTRA_PERSONAGEM"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val toolbar: Toolbar = findViewById(R.id.toolbar_detalhes)
        setSupportActionBar(toolbar)

        supportActionBar?.title = "Detalhes do Personagem"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val personagem = getPersonagemFromIntent()
        if (personagem != null) {
            val nome: TextView = findViewById(R.id.tv_nome_detalhe)
            val tipo: TextView = findViewById(R.id.tv_tipo_detalhe)
            val regiao: TextView = findViewById(R.id.tv_regiao_detalhe)
            val idade: TextView = findViewById(R.id.tv_idade_detalhe)
            val pokemon: TextView = findViewById(R.id.tv_pokemon_detalhe)
            val descricao: TextView = findViewById(R.id.tv_descricao_detalhe)

            nome.text = personagem.nome
            tipo.text = "Tipo: ${personagem.tipo}"
            regiao.text = "Região: ${personagem.regiao}"
            idade.text = "Idade: ${personagem.idade}"
            pokemon.text = "Pokémon Principal: ${personagem.pokemonPrincipal}"
            descricao.text = personagem.descricao
        }
    }


      // Esta função é chamada AUTOMATICAMENTE quando o utilizador clica na seta "voltar". COMENTÁRIOS PARA NÃO SE PERDER
      // Sem ela, o botão aparece, mas não faz nada.

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

      // Esta função recupera o objeto 'PersonagensPoke' que foi enviado da tela anterior. COMENTÁRIOS PARA NÃO SE PERDER

    private fun getPersonagemFromIntent(): PersonagensPoke? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(EXTRA_PERSONAGEM, PersonagensPoke::class.java)
        } else {
            intent.getSerializableExtra(EXTRA_PERSONAGEM) as? PersonagensPoke
        }
    }
}

