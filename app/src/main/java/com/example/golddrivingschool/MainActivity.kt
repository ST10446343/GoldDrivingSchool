package com.example.golddrivingschool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import com.example.golddrivingschool.screens.BookingScreen
import com.example.golddrivingschool.screens.BookingsScreen
import com.example.golddrivingschool.screens.HomeScreen
import com.example.golddrivingschool.screens.LoginScreen
import com.example.golddrivingschool.screens.ProfileScreen
import com.example.golddrivingschool.screens.ProgressScreen
import com.example.golddrivingschool.screens.RegisterScreen
import com.example.golddrivingschool.ui.theme.GoldDrivingSchoolTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            GoldDrivingSchoolTheme {

                GoldDrivingSchoolApp()
            }
        }
    }
}

@Composable
fun GoldDrivingSchoolApp() {

    var currentScreen by remember {
        mutableStateOf("login")
    }

    var studentName by remember {
        mutableStateOf("Student")
    }

    when (currentScreen) {

        "login" -> {

            LoginScreen(

                onLogin = { name ->

                    studentName = name
                    currentScreen = "home"
                },

                onRegister = {

                    currentScreen = "register"
                }
            )
        }

        "register" -> {

            RegisterScreen(

                onRegister = { name ->

                    studentName = name
                    currentScreen = "home"
                },

                onBack = {

                    currentScreen = "login"
                }
            )
        }

        "home" -> {

            MainNavigation(
                studentName = studentName,
                onLogout = {

                    currentScreen = "login"
                }
            )
        }
    }
}

@Composable
fun MainNavigation(
    studentName: String,
    onLogout: () -> Unit
) {

    var selectedTab by remember {
        mutableStateOf(0)
    }

    var showBookingScreen by remember {
        mutableStateOf(false)
    }

    if (showBookingScreen) {

        BookingScreen(
            onBack = {
                showBookingScreen = false
            }
        )

        return
    }

    Scaffold(

        bottomBar = {

            NavigationBar {

                NavigationBarItem(

                    selected = selectedTab == 0,

                    onClick = {
                        selectedTab = 0
                    },

                    icon = {

                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home"
                        )
                    },

                    label = {
                        Text("Home")
                    }
                )

                NavigationBarItem(

                    selected = selectedTab == 1,

                    onClick = {
                        selectedTab = 1
                    },

                    icon = {

                        Icon(
                            imageVector = Icons.Default.CalendarMonth,
                            contentDescription = "Bookings"
                        )
                    },

                    label = {
                        Text("Bookings")
                    }
                )

                NavigationBarItem(

                    selected = selectedTab == 2,

                    onClick = {
                        selectedTab = 2
                    },

                    icon = {

                        Icon(
                            imageVector = Icons.Default.DirectionsCar,
                            contentDescription = "Progress"
                        )
                    },

                    label = {
                        Text("Progress")
                    }
                )

                NavigationBarItem(

                    selected = selectedTab == 3,

                    onClick = {
                        selectedTab = 3
                    },

                    icon = {

                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile"
                        )
                    },

                    label = {
                        Text("Profiles")
                    }
                )
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            when (selectedTab) {

                0 -> {
                    HomeScreen(
                        studentName = studentName,
                        onBookLesson = {
                            showBookingScreen = true
                        }
                    )
                }

                1 -> {
                    BookingsScreen()
                }

                2 -> {
                    ProgressScreen()
                }

                3 -> {
                    ProfileScreen(
                        studentName = studentName,
                        onLogout = onLogout
                    )
                }
            }
        }
    }
}