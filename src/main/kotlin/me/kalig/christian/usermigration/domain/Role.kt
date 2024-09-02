package me.kalig.christian.usermigration.domain

class Role(val userId: Long, val role: String) {

    var id: Long? = null

    constructor(id: Long, userId: Long, role: String) : this(userId, role) {
        this.id = id
    }

}