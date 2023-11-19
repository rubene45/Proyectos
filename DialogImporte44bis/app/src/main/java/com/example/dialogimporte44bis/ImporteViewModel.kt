package com.example.dialogimporte44bis

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ImporteViewModel : ViewModel() {
    val importeMutableLiveData = MutableLiveData<String>()

    fun cambiarImporte(importe:String) {
        importeMutableLiveData.value = importe
    }
}