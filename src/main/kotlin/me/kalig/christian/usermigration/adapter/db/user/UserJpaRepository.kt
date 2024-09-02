package me.kalig.christian.usermigration.adapter.db.user

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserJpaRepository : JpaRepository<UserJpa, Long> {}