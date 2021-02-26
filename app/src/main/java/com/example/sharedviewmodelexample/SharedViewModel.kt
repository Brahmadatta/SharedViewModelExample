package com.example.sharedviewmodelexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

open class SharedViewModel : ViewModel() {

    val compositeDisposable = CompositeDisposable()



    val message by lazy { MutableLiveData<String>() }


    fun sendMessage(text : String)
    {
        message.value = text
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}