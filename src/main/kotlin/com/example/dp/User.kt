package com.example.dp

import org.ktorm.entity.Entity
import org.ktorm.schema.Table
import org.ktorm.schema.long
import org.ktorm.schema.varchar

interface UserEntity : Entity<UserEntity> {
    val uid : Int
}

object User : Table<UserEntity>("users") {
    val uid = varchar("uid").primaryKey()
    val phoneNumber = varchar("phone_number")
    val lat = long("lat")
    val long = long("long")
    val imageUrl = varchar("image_url")
    val firstName = varchar("first_name")
    val lastName = varchar("last_name")
}

