package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.golddrivingschool.ui.theme.GoldDrivingSchoolTheme

@Composable
fun LoginScreen(
    onLogin: (String) -> Unit,
    onRegister: () -> Unit
) {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }
    var errorMessage by remember {
        mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),

        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "GOLD",
            fontSize = 34.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Driving School",
            fontSize = 23.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Text(
            text = "Welcome Back",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Logins to see your driving lessons."
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = {
                Text("Emails Address")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(15.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Button(
            onClick = {

                val isValid = com.example.golddrivingschool.data.UserRepository.validateLogin(email, password)

                if (isValid) {
                    val name = if (email.contains("@")) {
                        email.substringBefore("@")
                    } else {
                        "Student"
                    }

                    onLogin(name)
                } else {
                    errorMessage = "Account does not exist or youve have entered the incorrect email or password"
                }

                             },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Login")
        }

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        TextButton(
            onClick = onRegister,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Dont have an account? Register")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    GoldDrivingSchoolTheme {
        LoginScreen(
            onLogin = {},
            onRegister = {}
        )
    }
}