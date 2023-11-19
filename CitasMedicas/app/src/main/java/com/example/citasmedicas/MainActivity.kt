package com.example.citasmedicas

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.citasmedicas.modelo.CitaData

class MainActivity : AppCompatActivity() {

    var citas = mutableListOf<CitaData>()
    lateinit var adapter:BandejaCitasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bandejaCitasRV: RecyclerView = findViewById(R.id.bandejaCitasRecycleView)

        citas.add(CitaData("Ruben Diaz", "15-11-2023", "652219323"))
        citas.add(CitaData("Alba Ontalba", "16-11-2023", "662432363"))
        citas.add(CitaData("Alejandro Lopez", "17-11-2023", "650329410"))

        adapter = BandejaCitasAdapter(citas, {
            realizarLlamada(it)
        },
            {modificarFecha(it)})

        bandejaCitasRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        bandejaCitasRV.adapter = adapter
    }

    fun realizarLlamada(position: Int) {
        var telefono = citas[position].telefono
        dialPhoneNumber(telefono)
    }

    fun dialPhoneNumber(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        startActivity(intent)
    }

    fun modificarFecha(position: Int) {
        var fecha = citas[position].fecha
        var divisionFecha = fecha.split("-")
        var bundle = bundleOf("dia" to divisionFecha[0], "mes" to divisionFecha[1], "año" to divisionFecha[2], "posicion" to position)

        val cambioFechaDialogFragment = CambioFechaDialogFragment()
        cambioFechaDialogFragment.arguments = bundle
        cambioFechaDialogFragment.show(supportFragmentManager, CambioFechaDialogFragment.TAG)

        supportFragmentManager.setFragmentResultListener(/* requestKey = */ "requestKey",this) { key, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported.
            val dia: String? = bundle.getString("dia")
            val mes: String? = bundle.getString("mes")
            val anno: String? = bundle.getString("año")

            citas[position].fecha = dia + "-" + mes + "-" + anno
            adapter.notifyDataSetChanged()
        }
    }

}