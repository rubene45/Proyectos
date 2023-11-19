package com.example.dialogimporteactivity44

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class CambioImporteDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var view=layoutInflater.inflate(R.layout.dialogfragment_cambioimporte, null)
        var importeEditText: EditText = view.findViewById(R.id.editTextImporte)

        importeEditText.setText(arguments?.getString("importe"))

        var dialog=AlertDialog.Builder(requireContext())
            .setView(view)
            .setMessage(getString(R.string.order_confirmation))
            .setPositiveButton(getString(R.string.ok)) { _,_ ->
                var importeEditText: EditText = view.findViewById(R.id.editTextImporte)
                var importe  = importeEditText.text.toString()
                parentFragmentManager.setFragmentResult("requestKey", bundleOf("importeKey" to importe))
            }
            .setNegativeButton(getString(R.string.cancel)) { _,_ ->
                dismiss()
            }
            .create()
        return dialog
    }

    companion object {
        const val TAG = "CambioImporteDialog"
    }

}