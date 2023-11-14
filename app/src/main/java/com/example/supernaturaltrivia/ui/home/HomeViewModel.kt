package com.example.supernaturaltrivia.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    val onEasyButtonClicked = MutableLiveData(false)
    val onMediuButtonClicked = MutableLiveData(false)
    val onHardButtonClicked = MutableLiveData(false)

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun onClickEasyButton(){
        onEasyButtonClicked.value=true
    }

    fun onClickMediumButton(){
        onEasyButtonClicked.value=true
    }

    fun onClickHardButton(){
        onEasyButtonClicked.value=true
    }
}