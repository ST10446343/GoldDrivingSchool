
package com.example.golddrivingschool.data

object UserRepository {

    private val registeredUsers = mutableMapOf(
        "student@gmail.com" to "password123"
    )
    var currentUserEmail: String = ""
    fun registerUser(email: String, password: String): Boolean {
        if (email.isBlank() || password.isBlank()) return false
        if (registeredUsers.containsKey(email)) return false // Account already exists

        registeredUsers[email] = password
        return true
    }

    fun validateLogin(email: String, password: String): Boolean {
        val isValid = registeredUsers[email] == password
        if (isValid) {
            currentUserEmail = email
    }
        return isValid
}
    fun updatePassword(oldPassword: String, newPassword: String): Boolean {
        if (currentUserEmail.isBlank()) return false
        if (registeredUsers[currentUserEmail] == oldPassword) {
            if (newPassword.isNotBlank()) {
                registeredUsers[currentUserEmail] = newPassword
                return true
        }
    }
    return false
}
}