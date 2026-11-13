package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Payment
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.golddrivingschool.components.ProfileItem
import androidx.compose.ui.tooling.preview.Preview
import com.example.golddrivingschool.ui.theme.GoldDrivingSchoolTheme

@Composable
fun ProfileScreen(
    studentName: String,
    onLogout: () -> Unit,
    onNavigateToSettings: () -> Unit = {},
    onNavigateToPersonalInfo: () -> Unit ={},
    onNavigateToPayments: () -> Unit = {}
) {

    var showLogoutDialog by remember {
        mutableStateOf(false)
    }

    if (showLogoutDialog) {

        AlertDialog(

            onDismissRequest = {
                showLogoutDialog = false
            },

            title = {
                Text("Logout")
            },

            text = {
                Text("Are you sure you want to logout?")
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        showLogoutDialog = false
                        onLogout()
                    }
                ) {

                    Text("Logout")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showLogoutDialog = false
                    }
                ) {

                    Text("Cancel")
                }
            }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp)
    ) {

        Text(
            text = "My Profile",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = studentName,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Student"
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        ProfileItem(
            icon = Icons.Default.Person,
            title = "Personal Information",
            onClick = onNavigateToPersonalInfo
        )

        ProfileItem(
            icon = Icons.Default.Settings,
            title = "Settings",
            onClick = onNavigateToSettings
        )

        ProfileItem(
            icon = Icons.Default.Payment,
            title = "Payments",
            onClick = onNavigateToPayments
        )

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Button(
            onClick = {
                showLogoutDialog = true
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Logout")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    GoldDrivingSchoolTheme {
        ProfileScreen(
            studentName = "Peter Parker",
            onLogout = {}
        )
    }
}
