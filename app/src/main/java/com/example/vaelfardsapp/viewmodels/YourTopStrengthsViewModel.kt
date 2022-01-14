package com.example.vaelfardsapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class YourTopStrengthsViewModel : ViewModel() {

    var is2Selected = MutableLiveData<Boolean>()

    init {
        is2Selected.value = false
    }

    fun getIs2Selected(): Boolean {
        return is2Selected.value!!
    }

    fun setIs2Selected(value: Boolean) {
        is2Selected.value = value
    }

}