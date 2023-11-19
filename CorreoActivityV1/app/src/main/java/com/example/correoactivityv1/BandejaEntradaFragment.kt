package com.example.correoactivityv1

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.correoactivityv1.modelo.CorreoData

class BandejaEntradaFragment: Fragment(R.layout.fragment_bandejaentrada) {

    var correos=mutableListOf<CorreoData>()
    lateinit var adapter:BandejaEntradaAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bandejaCorreosRV:RecyclerView=view.findViewById(R.id.correosEntradaRecycleView)

        correos.add(CorreoData("clientes@iberdrola.com","Factura","Su factura esta disponible"))
        correos.add(CorreoData("pepito@gmail.es","Quedada esta noche","Vamos esta noche"))
        correos.add(CorreoData("cc@facebook.com","Facebook","Fulanito tiene 99+ amigos nuevos"))

        bandejaCorreosRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        var funLlamarDetalle:(Int)->Unit={
            llamarDetalle(it)
        }

        adapter = BandejaEntradaAdapter(correos, {
            llamarDetalle(it)
        },
            {borrarCorreo(it)})

        bandejaCorreosRV.adapter=adapter
    }

    fun llamarDetalle(position: Int) {
        Log.i("EventoClick", "Fragmentbt"+position)
        var bundle = bundleOf("from" to correos[position].from,
            "asunto" to correos[position].asunto,
            "mensaje" to correos[position].mensaje)
        var navHostFragment = parentFragmentManager.findFragmentById(R.id.nav_host_fragment_container)
        val navController = navHostFragment?.findNavController()?.navigate(R.id.detalleCorreoFragment,bundle)
    }

    fun borrarCorreo(position: Int) {
        correos.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}