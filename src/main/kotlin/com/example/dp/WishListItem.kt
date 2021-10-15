package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.timestamp
import org.ktorm.schema.varchar
import java.sql.Timestamp

interface Wishlist : Entity<Wishlist> {
    val uid: String
    val product: ProductEntity
    val time: Timestamp
}


object WishListItem : Table<Wishlist>("") {
    val uid = varchar("uid")
    val productId = varchar("product_id").references(Product) { it.product }
    val time = timestamp("time")
}