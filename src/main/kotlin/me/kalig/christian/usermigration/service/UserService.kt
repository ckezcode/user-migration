package me.kalig.christian.usermigration.service

import me.kalig.christian.usermigration.business.userrole.UserRoleTransformer
import me.kalig.christian.usermigration.domain.Role
import me.kalig.christian.usermigration.domain.User
import me.kalig.christian.usermigration.domain.UserRole
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository,
    val roleRepository: RoleRepository
) {

    fun getUsers(): List<User> {
        return userRepository.findAll()
    }

    fun addUsers(users: List<User>): List<User> {
        return userRepository.saveAll(users)
    }

    fun addRoles(roles: List<Role>): List<Role> {
        return roleRepository.saveAll(roles)
    }

    fun getUserRoles(): List<UserRole> {
        return userRepository.findAll().map { user ->
            var roles = roleRepository.findAllByUserId(user.id).map { role -> role.role }
            UserRoleTransformer.transform(user, roles)
        }
    }

}