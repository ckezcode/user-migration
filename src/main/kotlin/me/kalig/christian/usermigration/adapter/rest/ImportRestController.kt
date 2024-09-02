package me.kalig.christian.usermigration.adapter.rest

import me.kalig.christian.usermigration.domain.Role
import me.kalig.christian.usermigration.domain.User
import me.kalig.christian.usermigration.service.UserService
import org.apache.commons.csv.CSVFormat
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.io.ByteArrayInputStream
import java.io.InputStreamReader

@RestController
@RequestMapping("/api/import")
class ImportRestController(val userService: UserService) {

    @PostMapping("/users")
    fun importUsers(@RequestBody usersCsv: String): ResponseEntity<List<User>> {
        val users = readUsersCsv(usersCsv)
        return ResponseEntity.ok(userService.addUsers(users))
    }

    @PostMapping("/roles")
    fun importRoles(@RequestBody rolesCsv: String): ResponseEntity<List<Role>> {
        val roles = readRolesCsv(rolesCsv)
        return ResponseEntity.ok(userService.addRoles(roles))
    }

    private fun readUsersCsv(usersCsv: String): List<User> {
        return getCSVParser().parse(getReader(usersCsv))
            .drop(1)
            .map {
                User(
                    id = it[0].toLong(),
                    mail = it[1],
                )
            }
    }

    private fun readRolesCsv(rolesCsv: String): List<Role> {
        return getCSVParser().parse(getReader(rolesCsv))
            .drop(1)
            .map {
                Role(
                    userId = it[0].toLong(),
                    role = it[1],
                )
            }
    }

    private fun getCSVParser(): CSVFormat {
        return CSVFormat.Builder.create(CSVFormat.DEFAULT).apply {
            setIgnoreSurroundingSpaces(true)
        }.build()
    }

    private fun getReader(usersCsv: String): InputStreamReader = ByteArrayInputStream(usersCsv.toByteArray()).reader()

}