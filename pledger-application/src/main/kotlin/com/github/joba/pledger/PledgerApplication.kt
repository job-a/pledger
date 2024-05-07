package com.github.joba.pledger

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PledgerApplication

fun main(args: Array<String>) {
	runApplication<PledgerApplication>(*args)
}
