package com.example.llamaractivity23

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var llamarImageView:ImageView = findViewById(R.id.imageViewTelefono)
        var telefonoEditText:EditText = findViewById(R.id.editTextTelefono)

        llamarImageView.setOnClickListener {
            var telefono = telefonoEditText.text.toString()
            dialPhoneNumber(telefono)
        }
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }
}