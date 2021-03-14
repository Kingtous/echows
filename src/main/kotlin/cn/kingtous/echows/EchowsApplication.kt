package cn.kingtous.echows

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component

@SpringBootApplication
class EchowsApplication

fun main(args: Array<String>) {
    runApplication<EchowsApplication>(*args)
}
