package com.example.telefonorvactivity51

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class TelefonoViewHolder(view: View): ViewHolder(view) {
    var telefonoTextView: TextView = view.findViewById(R.id.textViewTelefono)

    fun insertTelefono(telefono:String) {
        telefonoTextView.text = telefono
    }
}