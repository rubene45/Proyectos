package com.example.navfragmentactivity45

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class PrimeroFragment: Fragment(R.layout.fragment_primero) {

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
        var siguiente: Button = view.findViewById(R.id.button1Siguiente)
        siguiente.setOnClickListener {
            var navHostFragment=parentFragmentManager.findFragmentById(R.id.nav_host_fragment)
            var navControler=navHostFragment?.findNavController()?.navigate(R.id.segundoFragment)
        }
    }
}