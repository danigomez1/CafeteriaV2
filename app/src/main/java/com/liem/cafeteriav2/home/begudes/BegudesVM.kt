package com.liem.cafeteriav2.home.begudes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liem.cafeteriav2.home.ProductModel
import com.liem.cafeteriav2.home.ProductProvider

class BegudesVM: ViewModel() {

    private val _begudes = MutableLiveData<List<ProductModel>>().apply {
        value = ProductProvider.obtainTypeOfProduct("begudes")
    }

    val begudes: LiveData<List<ProductModel>> = _begudes

    fun refresh() {
        _begudes.value = ProductProvider.obtainTypeOfProduct("begudes")
    }
}