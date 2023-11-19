package com.example.navfragmentactivity45

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class SegundoFragment: Fragment(R.layout.fragment_segundo) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var anterior: Button = view.findViewById(R.id.button2Anterior)
        anterior.setOnClickListener {
            view.findNavController().navigate(R.id.tercerFragment)
        }

        var siguiente: Button = view.findViewById(R.id.button2Siguiente)
        siguiente.setOnClickListener {
            view.findNavController().navigate(R.id.primeroFragment)
        }
    }
}