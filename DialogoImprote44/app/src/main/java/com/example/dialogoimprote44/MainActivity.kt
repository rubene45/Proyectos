package com.example.dialogoimprote44

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val importeButton: Button = findViewById(R.id.buttonimporteButton)
        val importTextView: TextView = findViewById(R.id.textViewTexto1)

        importeButton.setOnClickListener {
            val importe = importTextView.text.toString() // Obtén el valor actual del TextView

            // Crea el diálogo y pasa el valor de importe
            val dialog = CambioImporteDialogFragment.newInstance(importe)
            dialog.show(supportFragmentManager, CambioImporteDialogFragment.TAG)
        }

        supportFragmentManager.setFragmentResultListener("requestKey", this) { key, bundle ->
            val importe = bundle.getString("importeKey")
            importTextView.text = importe
        }
    }

    companion object {
        const val TAG = "CambioImporteDialog"
    }

}