package com.example.telefonorvactivity51

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var telefonoEditText : EditText
    lateinit var guardarButton : Button
    var listaTelefonos = mutableListOf<String>()
    lateinit var telefonosRecycleView: RecyclerView
    var adapter= TelefonoAdapter(listaTelefonos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        rellenarRV()

        guardarButton.setOnClickListener {
            addTelefono(telefonoEditText.text.toString())
            adapter.notifyDataSetChanged()
        }
    }

    fun addTelefono(telefono:String) {
        listaTelefonos.add(telefono)
    }

    fun rellenarRV() {
        telefonosRecycleView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        telefonosRecycleView.adapter = adapter
    }

    fun init() {
        telefonoEditText = findViewById(R.id.editTextTelefono)
        guardarButton = findViewById(R.id.buttonGuardar)
        telefonosRecycleView = findViewById(R.id.telefonosRecycleView)
    }
}