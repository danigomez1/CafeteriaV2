package com.liem.cafeteriav2.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedVM: ViewModel() {
    private val _selectedItems = MutableLiveData<List<ProductModel>>().apply { value = mutableListOf() }
    val selectedItems: LiveData<List<ProductModel>> get() = _selectedItems

    private val _totalAmount = MutableLiveData<Double>().apply { value = 0.0 }
    val totalAmount: LiveData<Double> get() = _totalAmount

    fun addItem(product: ProductModel) {
        val currentList = _selectedItems.value?.toMutableList() ?: mutableListOf()
        val idx = currentList.indexOfFirst { it.name == product.name }

        if (idx != -1) {
            val exists = currentList[idx]
            currentList[idx] = exists.copy(quantity = exists.quantity + 1)
        } else {
            currentList.add(product.copy(quantity = 1))
        }

        _selectedItems.value = currentList
        updateTotalAmount()
    }

    private fun updateTotalAmount() {
        _totalAmount.value =_selectedItems.value?.sumOf { it.price.toDouble() * it.quantity } ?: 0.0
    }
}