package com.liem.cafeteriav2.home.plats

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liem.cafeteriav2.home.ProductModel
import com.liem.cafeteriav2.home.ProductProvider

class PlatsVM: ViewModel() {
    private val _plats = MutableLiveData<List<ProductModel>>().apply {
        value = ProductProvider.obtainTypeOfProduct("plats")
    }

    val plats: LiveData<List<ProductModel>> = _plats

    fun refresh() {
        _plats.value = ProductProvider.obtainTypeOfProduct("plats")
    }
}