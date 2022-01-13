package com.example.vaelfardsapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class YourTopStrengthsViewModel : ViewModel() {

    private var is2Selected: Boolean = false

    var ja = MutableLiveData<Boolean>()

    init {
        ja.value = false
    }

    fun getja(): Boolean {
        return ja.value!!
    }

    fun setja(value: Boolean) {
        Log.d("setjafromvm", value.toString())
        ja.value = value
    }


    fun getIs2Selected(): Boolean {
        return is2Selected
    }

    fun setIs2Selected(value: Boolean) {
        is2Selected = value
    }




}