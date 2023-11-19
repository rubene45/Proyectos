package com.example.dialogoimprote44

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment

class CambioImporteDialogFragment : DialogFragment() {
    private lateinit var importeEditText: EditText

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val view = layoutInflater.inflate(R.layout.dialagogfragment_cambioimportes, null)
        importeEditText = view.findViewById(R.id.editTextImporte)

        val dialog = AlertDialog.Builder(requireContext())
            .setView(view)
            .setMessage(getString(R.string.order_confirmation))
            .setPositiveButton(getString(R.string.ok)) { _, _ ->
                val importe = importeEditText.text.toString()
                parentFragmentManager.setFragmentResult("requestKey", bundleOf("importeKey" to importe))
            }
            .setNegativeButton(getString(R.string.cancel)) { _, _ ->
                dismiss()
            }
            .create()

        // Establecer el valor de importe en el EditText si está disponible
        val importe = arguments?.getString("importeKey")
        if (!importe.isNullOrEmpty()) {
            importeEditText.setText(importe)
        }

        return dialog
    }

    companion object {
        const val TAG = "CambioImporteDialog"

        fun newInstance(importe: String): CambioImporteDialogFragment {
            val fragment = CambioImporteDialogFragment()
            val args = Bundle()
            args.putString("importeKey", importe)
            fragment.arguments = args
            return fragment
        }
    }
}