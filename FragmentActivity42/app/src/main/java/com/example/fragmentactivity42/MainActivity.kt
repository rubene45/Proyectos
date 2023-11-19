package com.example.fragmentactivity42

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.add
import androidx.fragment.app.commit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var nombreTextView: TextView = findViewById(R.id.textViewTexto)

        var llamarFragButton : Button = findViewById(R.id.buttonLlamarFragment)
        llamarFragButton.setOnClickListener {
            if (savedInstanceState == null) {
                val bundle = bundleOf("nombre" to nombreTextView.text.toString())
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<ExampleFragment>(R.id.fragment_container_view, args=bundle)
                }
            }
        }
    }
}