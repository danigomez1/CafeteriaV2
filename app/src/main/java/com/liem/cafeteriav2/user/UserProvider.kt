package com.liem.cafeteriav2.user

class UserProvider {
    companion object {
        fun addNewUser(user: UserModel) {
            users.add(user)
        }
        fun obtainUser(name: String): UserModel? {
            return users.find {it.name == name}
        }

        private val users = mutableListOf(
            UserModel(
                name = "Dani",
                password = "admin"
            ),
            UserModel(
                name = "Joel",
                password = "admin"
            ),
            UserModel(
                name = "Nadir",
                password = "admin"
            ),
            UserModel(
                name = "Roger",
                password = "admin"
            ),
            UserModel(
                name = "Alex",
                password = "admin"
            )
        )
    }
}