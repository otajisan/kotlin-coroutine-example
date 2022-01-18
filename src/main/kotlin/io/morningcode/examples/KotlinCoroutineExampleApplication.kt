package io.morningcode.examples

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinCoroutineExampleApplication

fun main(args: Array<String>) {
	runApplication<KotlinCoroutineExampleApplication>(*args)
}
