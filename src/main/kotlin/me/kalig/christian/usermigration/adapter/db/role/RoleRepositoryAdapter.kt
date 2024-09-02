package me.kalig.christian.usermigration.adapter.db.role

import me.kalig.christian.usermigration.domain.Role
import me.kalig.christian.usermigration.service.RoleRepository
import org.springframework.stereotype.Component

@Component
class RoleRepositoryAdapter(val roleJpaRepository: RoleJpaRepository) : RoleRepository {

    override fun saveAll(roles: List<Role>): List<Role> {
        var roleJpas = RoleMapper.mapRoleList(roles)
        return RoleMapper.mapRoleJpaList(roleJpaRepository.saveAll(roleJpas))
    }

    override fun findAllByUserId(userId: Long): List<Role> {
        return RoleMapper.mapRoleJpaList(roleJpaRepository.findAllByUserId(userId))
    }

}