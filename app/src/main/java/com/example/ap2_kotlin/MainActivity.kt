package com.example.ap2_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.ap2_kotlin.ui.PersonagensAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Personagens Pokémon"



        val recyclerView: RecyclerView = findViewById(R.id.rv_personagens)
        val adapter = PersonagensAdapter()
        recyclerView.adapter = adapter
    }
}

