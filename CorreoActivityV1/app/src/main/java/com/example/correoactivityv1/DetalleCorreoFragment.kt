package com.example.correoactivityv1

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class DetalleCorreoFragment: Fragment(R.layout.fragment_detallecorreo) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var from:TextView = view.findViewById(R.id.textViewFrom)
        var asunto:TextView = view.findViewById(R.id.textViewAsunto)
        var mensaje:TextView = view.findViewById(R.id.textViewMensaje)
        from.text = arguments?.getString("from")
        asunto.text = arguments?.getString("asunto")
        mensaje.text = arguments?.getString("mensaje")
    }

}