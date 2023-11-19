package com.example.citasmedicas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.citasmedicas.modelo.CitaData

class BandejaCitasAdapter(val citas:List<CitaData>, val clickTelefono:(Int)->Unit, val clickModificar:(Int)->Unit): RecyclerView.Adapter<BandejaCitasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BandejaCitasViewHolder {
        // inflar la vista
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.item_cita, parent, false)
        return BandejaCitasViewHolder(view)
    }

    override fun getItemCount(): Int =citas.size

    override fun onBindViewHolder(holder: BandejaCitasViewHolder, position: Int) {
        holder.actualizar(citas[position], clickTelefono, clickModificar)
    }
}