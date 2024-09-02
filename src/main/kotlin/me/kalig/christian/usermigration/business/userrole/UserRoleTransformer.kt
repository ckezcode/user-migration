package me.kalig.christian.usermigration.business.userrole

import me.kalig.christian.usermigration.business.BaseTransformer
import me.kalig.christian.usermigration.domain.User
import me.kalig.christian.usermigration.domain.UserRole

class UserRoleTransformer {
    companion object UserRoleTransformer : BaseTransformer<UserRole> {
        override fun transform(user: User, roles: List<String>): UserRole {
            return UserRole(
                userId = user.id,
                mail = user.mail,
                roles = roles
            )
        }
    }
}