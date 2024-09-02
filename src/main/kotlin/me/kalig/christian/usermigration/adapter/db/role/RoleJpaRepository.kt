package me.kalig.christian.usermigration.adapter.db.role

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RoleJpaRepository : JpaRepository<RoleJpa, Long> {

    fun findAllByUserId(userId: Long): List<RoleJpa>

}