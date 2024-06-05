package org.example.xpfeatureflagging

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class XpFeatureFlaggingApplication

fun main(args: Array<String>) {
    runApplication<XpFeatureFlaggingApplication>(*args)
}
