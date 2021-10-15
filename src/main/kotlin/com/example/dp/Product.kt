package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.double
import org.ktorm.schema.float
import org.ktorm.schema.varchar

interface ProductEntity : Entity<ProductEntity> {
    val productId: String
    val category : CategoryEntity
    val title: String
    val price: Double
    val amount: Double
    val unit: Unit
}

object Product : Table<ProductEntity>("product") {
    val productId = varchar("product_id").primaryKey()
    val categoryName = varchar("category_name").references(Category) { it.category }
    val title = varchar("title")
    val price = double("price")
    val amount = double("amount")
    val unit = varchar("unit")
}