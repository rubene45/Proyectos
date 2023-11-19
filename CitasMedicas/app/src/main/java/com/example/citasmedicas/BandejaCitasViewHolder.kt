package com.example.citasmedicas

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.citasmedicas.modelo.CitaData

class BandejaCitasViewHolder(viewItem: View): RecyclerView.ViewHolder(viewItem) {
    val nombreTextView: TextView =viewItem.findViewById(R.id.textViewNombre)
    val fechaTextView: TextView =viewItem.findViewById(R.id.textViewFecha)
    val telefonoTextView: TextView =viewItem.findViewById(R.id.textViewTelefono)
    val telefonoImagen: ImageView =viewItem.findViewById(R.id.imageViewTelefono)
    val modificarFechaImagen: ImageView = viewItem.findViewById(R.id.imageViewModificarFecha)

    fun actualizar(citas: CitaData, clickTelefono:(Int)->Unit, clickModificar:(Int)->Unit) {
        nombreTextView.text = citas.nombre
        fechaTextView.text = citas.fecha
        telefonoTextView.text = citas.telefono
        telefonoImagen.setOnClickListener {
            clickTelefono(adapterPosition)
        }
        modificarFechaImagen.setOnClickListener {
            clickModificar(adapterPosition)
        }
    }
}