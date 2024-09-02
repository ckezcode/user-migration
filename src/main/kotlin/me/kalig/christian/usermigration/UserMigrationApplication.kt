package me.kalig.christian.usermigration

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class UserMigrationApplication

fun main(args: Array<String>) {
    runApplication<UserMigrationApplication>(*args)
}
