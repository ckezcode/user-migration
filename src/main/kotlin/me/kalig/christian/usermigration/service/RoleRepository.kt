package me.kalig.christian.usermigration.service

import me.kalig.christian.usermigration.domain.Role

interface RoleRepository {

    fun saveAll(roles: List<Role>): List<Role>

    fun findAllByUserId(userId: Long): List<Role>

}