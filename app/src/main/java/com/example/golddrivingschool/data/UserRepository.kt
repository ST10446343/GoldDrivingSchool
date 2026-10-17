
package com.example.golddrivingschool.data

object UserRepository {

    private val registeredUsers = mutableMapOf(
        "student@gmail.com" to "password123"
    )

    fun registerUser(email: String, password: String): Boolean {
        if (email.isBlank() || password.isBlank()) return false
        if (registeredUsers.containsKey(email)) return false // Account already exists

        registeredUsers[email] = password
        return true
    }

    fun validateLogin(email: String, password: String): Boolean {
        return registeredUsers[email] == password
    }
}