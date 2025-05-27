package com.liem.cafeteriav2.login

import androidx.lifecycle.ViewModel
import com.liem.cafeteriav2.user.UserProvider

class LoginVM : ViewModel() {
    fun login (username: String, password: String): Boolean {
        val user = UserProvider.obtainUser(username)

        if (user == null) {
            return false
        } else if (user.password != password) {
            return false
        } else {
            return true
        }
    }
}