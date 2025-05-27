package com.liem.cafeteriav2.home

class ProductProvider {
    companion object {
        fun obtainTypeOfProduct(type: String): List<ProductModel> {
            return products.filter {it.type == type}
        }

        private val products = mutableListOf(
            ProductModel(
                type = "begudes",
                name = "nestea",
                price = "2",
                quantity = 0
            ),
            ProductModel(
                type = "begudes",
                name = "aigua",
                price = "1",
                quantity = 0
            ),
            ProductModel(
                type = "plats",
                name = "hamburguesa",
                price = "10",
                quantity = 0
            ),
            ProductModel(
                type = "plats",
                name = "macarrons",
                price = "5",
                quantity = 0
            ),
            ProductModel(
                type = "postres",
                name = "iogurt",
                price = "2",
                quantity = 0
            ),
            ProductModel(
                type = "postres",
                name = "fruita",
                price = "3",
                quantity = 0
            )
        )
    }
}