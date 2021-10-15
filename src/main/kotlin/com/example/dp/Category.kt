package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.varchar

interface CategoryEntity : Entity<CategoryEntity> {
    val categoryImagerUrl: String
    val categoryName: String
}

object Category : Table<CategoryEntity>("category") {
    val categoryName = varchar("category_name").primaryKey()
    val categoryImagerUrl = varchar("category_image_url")
}