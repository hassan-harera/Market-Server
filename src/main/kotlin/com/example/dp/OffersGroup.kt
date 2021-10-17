package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.int
import org.ktorm.schema.varchar


interface OfferGroupsEntity : Entity<OfferGroupsEntity> {}

object OffersGroup : Table<OfferGroupsEntity>("offer_group") {
    val offersGroupId = int("offers_group_id").primaryKey()
    val groupName = varchar("group_name").primaryKey()
    val groupImageUrl = varchar("group_image_url").primaryKey()
}