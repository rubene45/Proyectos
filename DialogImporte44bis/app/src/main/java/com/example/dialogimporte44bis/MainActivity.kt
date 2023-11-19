package com.example.dialogimporte44bis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.fragment.app.activityViewModels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var importeButton: Button = findViewById(R.id.buttonCambiar)
        var importeTextView:TextView=findViewById(R.id.textViewImporte)

        importeButton.setOnClickListener {
            CambioImporteDialogFragment().show(
                supportFragmentManager, CambioImporteDialogFragment.TAG)
        }

        val viewModel: ImporteViewModel by viewModels()

        viewModel.importeMutableLiveData.observe(this, {
            importeTextView.text=it
        })
        /* supportFragmentManager.setFragmentResultListener(/* requestKey = */ "requestKey",this){
                key, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported.
            val importe:String? = bundle.getString("importeKey")

            importeTextView.setText(importe)
        } */

    }
}