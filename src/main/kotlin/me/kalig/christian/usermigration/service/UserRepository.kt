package me.kalig.christian.usermigration.service

import me.kalig.christian.usermigration.domain.User

interface UserRepository {

    fun findAll(): List<User>

    fun saveAll(users: List<User>): List<User>

}