package com.example.citasmedicas

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class CambioFechaDialogFragment: DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var view=layoutInflater.inflate(R.layout.dialogfragment_cambiofecha, null)
        var diaEditText: EditText = view.findViewById(R.id.editTextDia)
        var mesEditText: EditText = view.findViewById(R.id.editTextMes)
        var annoEditText: EditText = view.findViewById(R.id.editTextAño)

        diaEditText.setText(arguments?.getString("dia"))
        mesEditText.setText(arguments?.getString("mes"))
        annoEditText.setText(arguments?.getString("año"))

        var dialog= AlertDialog.Builder(requireContext())
            .setView(view)
            .setMessage(getString(R.string.order_confirmation))
            .setPositiveButton(getString(R.string.ok)) { _,_ ->
                var dia  = diaEditText.text.toString()
                var mes = mesEditText.text.toString()
                var anno = annoEditText.text.toString()
                parentFragmentManager.setFragmentResult("requestKey", bundleOf("dia" to dia, "mes" to mes, "año" to anno))
            }
            .create()
        return dialog
    }

    companion object {
        const val TAG = "CambioFechaDialog"
    }
}