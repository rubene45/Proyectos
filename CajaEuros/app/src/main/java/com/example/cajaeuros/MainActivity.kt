package com.example.cajaeuros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var dosEurosEditText: EditText
    lateinit var unEuroEditText:EditText
    lateinit var cincuentaCentEditText:EditText
    lateinit var veinteCentEditText:EditText
    lateinit var diezCentEditText:EditText
    lateinit var calcularButton:Button
    lateinit var resultadoTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dosEurosEditText = findViewById(R.id.editText2euros)
        unEuroEditText = findViewById(R.id.editTextText1euro)
        cincuentaCentEditText = findViewById(R.id.editText50cent)
        veinteCentEditText = findViewById(R.id.editText20cent)
        diezCentEditText = findViewById(R.id.editText10cent)
        calcularButton = findViewById(R.id.buttonCalcular)
        resultadoTextView = findViewById(R.id.textViewResultado)

        Log.i("Traza_CajaEuros", "2euros:" + dosEurosEditText.text.toString())

        calcularButton.setOnClickListener { View ->
            Log.i("Traza_CajaEuros", "Pulsando boton ...")
            calcularEuros()
        }

    }

    private fun calcularEuros() {
        try {
            var dosEurosImporte = 2 * dosEurosEditText.text.toString().toInt()
            var unEuroImporte = 1 * unEuroEditText.text.toString().toInt()
            var cincuentaCentImporte = 0.5 * cincuentaCentEditText.text.toString().toInt()
            var veinteCentImporte = 0.2 * veinteCentEditText.text.toString().toInt()
            var diezCentImporte = 0.1 * diezCentEditText.text.toString().toInt()

            var resultado =
                dosEurosImporte + unEuroImporte + cincuentaCentImporte + veinteCentImporte + diezCentImporte

            resultadoTextView.setText(resultadoTextView.text.toString() + resultado.toString())
        } catch (e:NumberFormatException) {
            Toast.makeText(this, "formato incorrecto",Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?) {
        if (v != null) {
            if (v.id==R.id.buttonCalcular) {
                calcularEuros()
            }
        }
    }
}