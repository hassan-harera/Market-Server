package com.example.dp

import org.ktorm.schema.Table
import org.ktorm.schema.varchar


object ProductImages : Table<Nothing>("product_images") {
    val productId = varchar("product_id")
    val imageUrl = varchar("image_url")
}