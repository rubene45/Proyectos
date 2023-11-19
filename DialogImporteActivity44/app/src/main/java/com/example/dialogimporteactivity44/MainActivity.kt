package com.example.dialogimporteactivity44

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var importeTextView:TextView=findViewById(R.id.textViewImporte)
        var importeButton: Button = findViewById(R.id.buttonCambiar)


        importeButton.setOnClickListener {
            val bundle = bundleOf("importe" to importeTextView.text.toString())
            val dialogFragment = CambioImporteDialogFragment()
            dialogFragment.arguments = bundle
            dialogFragment.show(
                supportFragmentManager, CambioImporteDialogFragment.TAG)
        }

        supportFragmentManager.setFragmentResultListener(/* requestKey = */ "requestKey",this){
                key, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported.
            val importe:String? = bundle.getString("importeKey")

            importeTextView.setText(importe)
        }

    }
}