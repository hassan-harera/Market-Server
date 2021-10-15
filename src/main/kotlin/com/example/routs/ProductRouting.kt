package com.example.routs

import com.example.dp.Product
import io.ktor.routing.*

fun Route.productRouting() {
    route("/products") {
        get("{productId}") {

        }

        get  {

        }

        post("add") {

        }
    }
}
