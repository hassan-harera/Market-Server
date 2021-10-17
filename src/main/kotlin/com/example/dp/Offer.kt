package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.time
import org.ktorm.schema.varchar

interface OfferEntity : Entity<OfferEntity> {
    val offerGroup: OfferGroupsEntity
    val product: ProductEntity
}

object Offer : Table<OfferEntity>("offers") {
    val productId = int("product_id").references(Product) { it.product }
    val offerId = int("offer_id")
    val startTime = time("start_time")
    val endTime = time("end_time")
    val offerImageUrl = varchar("offer_image_url")
    val offerTitle = varchar("offer_title")
    val offerGroup = int("offers_group_id").references(OffersGroup) { it.offerGroup }
}