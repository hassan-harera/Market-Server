package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.*
import java.sql.Timestamp

interface CartEntity : Entity<CartEntity> {
    var product: ProductEntity
    var user: UserEntity
}

object Cart : Table<CartEntity>("carts") {
    val uid = int("uid").references(User) { it.user }
    var productId = int("product_id").references(Product) { it.product }
    var quantity = double("quantity")
    var time = timestamp("time")
}