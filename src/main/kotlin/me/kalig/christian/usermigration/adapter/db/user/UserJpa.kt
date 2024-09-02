package me.kalig.christian.usermigration.adapter.db.user

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class UserJpa(
    @Id
    @Column(name = "id")
    var id: Long = 0,

    @Column(name = "mail")
    var mail: String = "",
)