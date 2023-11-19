package com.example.telefonorvactivity51

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class TelefonoAdapter(val telefonos:List<String>): RecyclerView.Adapter<TelefonoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TelefonoViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)
        var view = layoutInflater.inflate(R.layout.item_telefono, parent, false)
        return TelefonoViewHolder(view)
    }

    override fun getItemCount(): Int= telefonos.size

    override fun onBindViewHolder(holder: TelefonoViewHolder, position: Int) {
        holder.insertTelefono(telefonos[position])
    }
}