package com.example.dp

import kotlinx.serialization.Serializable
import org.ktorm.entity.Entity
import org.ktorm.schema.*

interface ProductEntity : Entity<ProductEntity> {
    val productId: Int
    val category: CategoryEntity
    val title: String
    val price: Double
    val amount: Double
    val unit: Unit
}

object Product : Table<ProductEntity>("product") {
    val productId = int("product_id").primaryKey()
    val categoryName = varchar("category_name").references(Category) { it.category }
    val title = varchar("title")
    val price = double("price")
    val amount = double("amount")
    val unit = varchar("unit")
}