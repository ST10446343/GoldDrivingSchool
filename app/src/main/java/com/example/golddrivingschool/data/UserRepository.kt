
package com.example.golddrivingschool.data
import java.security.MessageDigest
object UserRepository {
    private fun hashPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

    private val registeredUsers = mutableMapOf(
        "student@gmail.com" to hashPassword("password123")
    )
    private val userProfiles = mutableMapOf(
        "student@gmail.com" to UserProfile(
            firstName = "Student",
            lastName = "User",
            email = "student@gmail.com",
            phone = "0821234567"
        )
    )
    var currentUserEmail: String = ""
    fun registerUser(
        firstName: String,
        lastName: String,
        email: String,
        phone: String,
        password: String
    ): Boolean {
        if (email.isBlank() || password.isBlank()) return false
        if (registeredUsers.containsKey(email)) return false // Account already exists

        registeredUsers[email] = hashPassword(password)
        userProfiles[email] = UserProfile(
            firstName = firstName.ifBlank { "Student" },
            lastName = lastName,
            email = email,
            phone = phone.ifBlank { "N/A" }
        )
        return true
    }

    fun registerUser(email: String, password: String): Boolean {
        return registerUser("Student", "", email, "N/A", password)
    }

    fun validateLogin(email: String, password: String): Boolean {
        val hashedPassword = hashPassword(password)
        val isValid = registeredUsers[email] == hashedPassword
        if (isValid) {
            currentUserEmail = email
            if (!userProfiles.containsKey(email)) {
                userProfiles[email] = UserProfile(
                    firstName = email.substringBefore("@"),
                    lastName = "",
                    email = email,
                    phone = "N/A"
                )
            }
        }
        return isValid
    }

    fun updatePassword(oldPassword: String, newPassword: String): Boolean {
        if (currentUserEmail.isBlank()) return false
        val hashedOldPassword = hashPassword(oldPassword)
        if (registeredUsers[currentUserEmail] == hashedOldPassword) {
            if (newPassword.isNotBlank()) {
                registeredUsers[currentUserEmail] = hashPassword(newPassword)
                return true
            }
        }
        return false
    }

    fun getCurrentProfile(): UserProfile {
        return userProfiles[currentUserEmail] ?: UserProfile(
            firstName = "Student",
            lastName = "",
            email = currentUserEmail.ifBlank { "student@gmail.com" },
            phone = "N/A"
        )
    }

    fun updateProfile(firstName: String, lastName: String) {
        if (currentUserEmail.isNotBlank()) {
            val current = getCurrentProfile()
            userProfiles[currentUserEmail] = current.copy(
                firstName = firstName,
                lastName = lastName
            )
        }
    }
    fun updatePaymentMethod(cardHolderName: String, cardNumber: String, expiryDate: String, cvv: String) {
        if (currentUserEmail.isNotBlank()) {
            val current = getCurrentProfile()
            userProfiles[currentUserEmail] = current.copy(
                cardHolderName = cardHolderName,
                cardNumber = cardNumber,
                expiryDate = expiryDate,
                cvv = cvv
            )
        }
    }
}
    data class UserProfile(
        val firstName: String,
        val lastName: String,
        val email: String,
        val phone: String,
        val cardHolderName: String = "",
        val cardNumber: String = "",
        val expiryDate: String = "",
        val cvv: String = ""
    )
