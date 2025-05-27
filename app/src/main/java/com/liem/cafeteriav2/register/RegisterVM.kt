package com.liem.cafeteriav2.register

import androidx.lifecycle.ViewModel
import com.liem.cafeteriav2.user.UserModel
import com.liem.cafeteriav2.user.UserProvider

class RegisterVM : ViewModel() {
    fun createUser(name: String, password: String) {
        UserProvider.addNewUser(UserModel(name, password))
    }
}