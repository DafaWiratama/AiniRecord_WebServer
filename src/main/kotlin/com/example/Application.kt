package com.example

import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File

val PATH = "\\\\ST-WIRATAMA-PC\\Temp\\Project Website"

fun main() {
    embeddedServer(Netty, host = "24.24.24.16", port = 8000) {
        routing {
            get("/") {
                call.respondFile(File("${PATH}\\index.html"))
            }

            get("/{view}") {
                val view = call.parameters["view"]
                call.respondFile(File("${PATH}\\view\\$view.html"))
            }

            get("template/{view}") {
                val view = call.parameters["view"]
                call.respondFile(File("${PATH}\\view\\template\\$view.html"))
            }

            get("css/{filename}") {
                val filename = call.parameters["filename"]
                call.respondFile(File("$PATH\\css\\$filename"))
            }
            get("js/{filename}") {
                val filename = call.parameters["filename"]
                call.respondFile(File("$PATH\\js\\$filename"))
            }
            get("fonts/{filename}") {
                val filename = call.parameters["filename"]
                    call.respondFile(File("$PATH\\fonts\\$filename"))
            }
            get("image/{folder}/{filename}") {
                val folder = call.parameters["folder"]
                val filename = call.parameters["filename"]
                call.respondFile(File("$PATH\\images\\$folder\\$filename"))
            }
        }
    }.start(wait = true)
}

