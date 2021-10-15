package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.time
import org.ktorm.schema.varchar

interface OfferEntity : Entity<OfferEntity> {
    val product: ProductEntity
}

object Offer : Table<OfferEntity>("offers") {
    val productId = varchar("product_id").references(Product) { it.product }
    val offerId = varchar("offer_id")
    val startTime = time("start_time")
    val endTime = time("end_time")
    val offerImageUrl = varchar("offer_image_url")
    val offerTitle = varchar("offer_title")
    val offerTypeId = varchar("offer_type_id")
}