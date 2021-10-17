package com.example.dp

import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


object ProductImages : Table<Nothing>("product_images") {
    val productId = int("product_id")
    val imageUrl = varchar("product_image_url")
}