package com.example.notasactividad21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class ParametroNotasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parametro_notas)

        val notaPSP = intent.getStringExtra("notaPSP")?:"0"
        val notaPMDM = intent.getStringExtra("notaPMDM")?:"0"
        val notaAD = intent.getStringExtra("notaAD")?:"0"
        val notaDI = intent.getStringExtra("notaDI")?:"0"

        Log.d("Traza:", "PSP:"+notaPSP)
        Log.d("Traza:", "PMDM:"+notaPMDM)
        Log.d("Traza:", "DI:"+notaDI)
        Log.d("Traza:", "AD:"+notaAD)

        var notas = listOf<Int>(notaPSP.toInt(), notaPMDM.toInt(), notaAD.toInt(), notaDI.toInt())

        var media = notas.average()
        var maximo=notas.max()
        var minimo=notas.min()

        var mediaTextView: TextView = findViewById(R.id.textViewMedia)
        var maximoTextView: TextView = findViewById(R.id.textViewMaximo)
        var minimoTextView: TextView = findViewById(R.id.textViewMinimo)

        mediaTextView.setText("Media: " + media)
        maximoTextView.setText("Maximo: " + maximo)
        minimoTextView.setText("Minimo: " + minimo)
    }
}