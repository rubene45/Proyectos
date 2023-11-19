package com.example.navfragmentactivity43

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace

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
            parentFragmentManager.popBackStack()
        }

        var siguiente: Button = view.findViewById(R.id.button2Siguiente)
        siguiente.setOnClickListener {
            parentFragmentManager.commit {
                replace<TercerFragment>(R.id.fragment_container_view)
                setReorderingAllowed(true)
                addToBackStack("name")
            }
        }
    }
}