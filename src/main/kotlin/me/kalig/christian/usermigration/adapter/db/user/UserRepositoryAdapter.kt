package me.kalig.christian.usermigration.adapter.db.user

import me.kalig.christian.usermigration.domain.User
import me.kalig.christian.usermigration.service.UserRepository
import org.springframework.stereotype.Component

@Component
class UserRepositoryAdapter(val userJpaRepository: UserJpaRepository) : UserRepository {

    override fun findAll(): List<User> {
        return UserMapper.mapUserJpaList(userJpaRepository.findAll())
    }

    override fun saveAll(users: List<User>): List<User> {
        var userJpas = UserMapper.mapUserList(users)
        return UserMapper.mapUserJpaList(userJpaRepository.saveAll(userJpas))
    }

}