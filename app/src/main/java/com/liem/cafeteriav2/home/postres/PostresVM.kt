package com.liem.cafeteriav2.home.postres

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.liem.cafeteriav2.home.ProductModel
import com.liem.cafeteriav2.home.ProductProvider

class PostresVM: ViewModel() {
    private val _postres = MutableLiveData<List<ProductModel>>().apply {
        value = ProductProvider.obtainTypeOfProduct("postres")
    }

    val postres: LiveData<List<ProductModel>> = _postres

    fun refresh() {
        _postres.value = ProductProvider.obtainTypeOfProduct("postres")
    }
}