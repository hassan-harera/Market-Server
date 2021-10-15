package com.example

import com.example.routs.productRouting
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.application.*
import io.ktor.client.features.json.*
import io.ktor.http.*
import io.ktor.routing.*
import kotlinx.serialization.json.Json

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

fun Application.module() {
    routing {
        productRouting()
    }
}