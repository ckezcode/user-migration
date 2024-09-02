package me.kalig.christian.usermigration.adapter.db.role

import me.kalig.christian.usermigration.domain.Role

class RoleMapper {
    companion object {
        fun mapRole(role: Role): RoleJpa {
            return RoleJpa(id = role.id, userId = role.userId, role = role.role)
        }

        fun mapRoleList(roles: List<Role>): List<RoleJpa> {
            return roles.map { mapRole(it) }
        }

        fun mapRoleJpa(roleJpa: RoleJpa): Role {
            if (roleJpa.id == null) {
                return Role(userId = roleJpa.userId, role = roleJpa.role)
            }
            return Role(id = roleJpa.id!!, userId = roleJpa.userId, role = roleJpa.role)
        }

        fun mapRoleJpaList(roles: List<RoleJpa>): List<Role> {
            return roles.map { mapRoleJpa(it) }
        }
    }
}