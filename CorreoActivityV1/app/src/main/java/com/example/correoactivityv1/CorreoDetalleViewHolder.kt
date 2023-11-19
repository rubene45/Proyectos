package com.example.correoactivityv1

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.correoactivityv1.modelo.CorreoData

class CorreoDetalleViewHolder(viewItem: View, onItemClick:(Int)->Unit): RecyclerView.ViewHolder(viewItem) {
    val fromTextView:TextView=viewItem.findViewById(R.id.textViewFrom)
    val asuntoTextView:TextView=viewItem.findViewById(R.id.textViewAsunto)
    val mensajeTextView:TextView=viewItem.findViewById(R.id.textViewMensaje)
    val papelera:ImageView=viewItem.findViewById(R.id.imageViewPapalera)

    init {
        viewItem.setOnClickListener {
            onItemClick(adapterPosition)
        }
    }

    fun actualizar(correo: CorreoData, clickPapelera:(Int)->Unit) {
        fromTextView.text=correo.from
        asuntoTextView.text=correo.asunto
        mensajeTextView.text=correo.mensaje
        papelera.setOnClickListener {
            clickPapelera(adapterPosition)
        }
    }
}