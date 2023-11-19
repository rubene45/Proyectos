package com.example.alarmaactivity23

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var botonImageView:ImageView = findViewById(R.id.imageViewAlarma)
        var horaEditText: EditText = findViewById(R.id.editTextHora)
        var minEditText: EditText = findViewById(R.id.editTextMinuto)
        var descEditText: EditText = findViewById(R.id.editTextDescripcion)

        botonImageView.setOnClickListener {
            var horas = horaEditText.text.toString().toInt()
            var minutos = minEditText.text.toString().toInt()
            var descripcion = descEditText.text.toString()
            createAlarm(descripcion, horas, minutos)
        }
    }

    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        startActivity(intent)
    }
}