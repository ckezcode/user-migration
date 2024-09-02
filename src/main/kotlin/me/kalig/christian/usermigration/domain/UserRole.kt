package me.kalig.christian.usermigration.domain

class UserRole(
    val userId: Long,
    val mail: String,
    val roles: List<String>
)