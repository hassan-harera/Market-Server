package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.timestamp
import org.ktorm.schema.varchar
import java.sql.Timestamp

interface WishlistEntity : Entity<WishlistEntity> {
    val user: UserEntity
    val product: ProductEntity
}

object Wishlist : Table<WishlistEntity>("wishlist") {
    val uid = int("uid").references(User) { it.user }
    val productId = int("product_id").references(Product) { it.product }
    val time = timestamp("time")
}