package com.example.correoactivityv1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.correoactivityv1.modelo.CorreoData

class BandejaEntradaAdapter(val correos:List<CorreoData>,
    val onItemClick:(Int)->Unit,
    val clickPapelera:(Int)->Unit): RecyclerView.Adapter<CorreoDetalleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CorreoDetalleViewHolder {
        // inflar la vista
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.item_correo, parent, false)
        return CorreoDetalleViewHolder(view, onItemClick)
    }

    override fun getItemCount(): Int =correos.size

    override fun onBindViewHolder(holder: CorreoDetalleViewHolder, position: Int) {
        holder.actualizar(correos[position], clickPapelera)
    }

}