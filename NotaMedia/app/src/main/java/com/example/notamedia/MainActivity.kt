package com.example.notamedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var calcularButton:Button
    lateinit var PMDMEditText:EditText
    lateinit var accesoADatosEditText:EditText
    lateinit var PSPEditText:EditText
    lateinit var EIEEditText:EditText
    lateinit var SGEEditText:EditText
    lateinit var desarrolloInterfacesEditText:EditText
    lateinit var inglesEditText:EditText
    lateinit var resultadoTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        PMDMEditText=findViewById(R.id.editTextPMDM)
        PSPEditText=findViewById(R.id.editTextPSP)
        accesoADatosEditText=findViewById(R.id.editTextAcceso)
        EIEEditText=findViewById(R.id.editTextEIE)
        inglesEditText=findViewById(R.id.editTextIngles)
        desarrolloInterfacesEditText=findViewById(R.id.editTextDesarrolloInterfaces)
        SGEEditText=findViewById(R.id.editTextSGE)
        resultadoTextView = findViewById(R.id.textViewResultado)
        calcularButton=findViewById(R.id.buttonCalcular)


        calcularButton.setOnClickListener { View->
            var media = calcularMedia()
            resultadoTextView.setText("La media es: " + media.toString())
        }
    }

    fun calcularMedia(): Double {
        try {
            var resultado =
                ( PMDMEditText.text.toString().toDouble() + PSPEditText.text.toString().toDouble() +
                        accesoADatosEditText.text.toString().toDouble() + EIEEditText.text.toString().toDouble() +
                        inglesEditText.text.toString().toDouble() + desarrolloInterfacesEditText.text.toString().toDouble() +
                        SGEEditText.text.toString().toDouble() ) / 7

            return resultado;

        } catch (e:NumberFormatException) {
            Toast.makeText(this, "formato incorrecto", Toast.LENGTH_LONG).show()
            return 0.0;
        }
    }
}
