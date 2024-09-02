package me.kalig.christian.usermigration.adapter.rest

import me.kalig.christian.usermigration.domain.User
import me.kalig.christian.usermigration.domain.UserRole
import me.kalig.christian.usermigration.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ExportRestController(val userService: UserService) {

    @GetMapping("/users")
    fun getUsers(): ResponseEntity<List<User>> {
        return ResponseEntity.ok(userService.getUsers())
    }

    @GetMapping("/userroles")
    fun getUserRoles(): ResponseEntity<List<UserRole>> {
        return ResponseEntity.ok(userService.getUserRoles())
    }

}