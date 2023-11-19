package com.example.notasactividad21

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var notaPSP: EditText = findViewById(R.id.editTextPSP)
        var notaPMDM: EditText = findViewById(R.id.editTextPMDM)
        var notaDI: EditText = findViewById(R.id.editTextDesInt)
        var notaAC: EditText = findViewById(R.id.editTextAccesoDatos)

        var calcularButton: Button = findViewById(R.id.buttonCalcular)
        calcularButton.setOnClickListener {
            val intent = Intent(this, ParametroNotasActivity::class.java).apply {
                putExtra("notaPSP", notaPSP.text.toString())
                putExtra("notaPMDM", notaPMDM.text.toString())
                putExtra("notaDI", notaDI.text.toString())
                putExtra("notaAD", notaAC.text.toString())
            }
            startActivity(intent)
        }
    }
}