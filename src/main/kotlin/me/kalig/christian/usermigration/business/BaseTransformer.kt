package me.kalig.christian.usermigration.business

import me.kalig.christian.usermigration.domain.User

interface BaseTransformer<T> {
    fun transform(user: User, roles: List<String>): T
}