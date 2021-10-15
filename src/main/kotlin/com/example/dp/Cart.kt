package com.example.dp

import com.harera.model.modelset.User
import com.harera.model.modelset.UserEntity
import org.ktorm.entity.Entity
import org.ktorm.schema.*

interface CartEntity : Entity<CartEntity> {
    var product: ProductEntity
    var user: UserEntity
}

object Cart : Table<CartEntity>("carts") {
    val uid = varchar("uid").references(User) { it.user }
    var cartItemId = varchar("cart_item_id").primaryKey()
    var productId = varchar("product_id").references(Product) { it.product }
    var quantity = int("quantity")
    var time = time("time")
}