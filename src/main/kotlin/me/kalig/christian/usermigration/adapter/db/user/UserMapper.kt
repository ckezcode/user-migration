package me.kalig.christian.usermigration.adapter.db.user

import me.kalig.christian.usermigration.domain.User

class UserMapper {
    companion object {
        fun mapUser(user: User): UserJpa {
            return UserJpa(id = user.id, mail = user.mail)
        }

        fun mapUserList(users: List<User>): List<UserJpa> {
            return users.map { mapUser(it) }
        }

        fun mapUserJpa(userJpa: UserJpa): User {
            return User(id = userJpa.id, mail = userJpa.mail)
        }

        fun mapUserJpaList(users: List<UserJpa>): List<User> {
            return users.map { mapUserJpa(it) }
        }
    }
}