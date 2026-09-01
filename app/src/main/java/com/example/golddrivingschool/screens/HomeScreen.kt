package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.golddrivingschool.components.DashboardCard

@Composable
fun HomeScreen(
    studentName: String,
    onBookLesson: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        item {

            Text(
                text = "Gold Driving School",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Welcome, $studentName!",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Ready for you next driving lesson?"
            )

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            Button(
                onClick = onBookLesson,
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = null
                )

                Text("  Book a Lesson")
            }

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            DashboardCard(
                title = "Next Lesson",
                value = "15 June",
                description = "14:00 • Instructor Peter"
            )

            DashboardCard(
                title = "Lessons Completed",
                value = "8 / 20",
                description = "Keep going!"
            )

            DashboardCard(
                title = "Outstanding Balance",
                value = "R850",
                description = "Current balance"
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Text(
                text = "Overall Progress",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            LinearProgressIndicator(
                progress = { 0.40f },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            Spacer(
                modifier = Modifier.height(5.dp)
            )

            Text(
                text = "40% completed"
            )
        }
    }
}