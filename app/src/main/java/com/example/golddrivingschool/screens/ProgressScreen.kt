package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.golddrivingschool.components.SkillProgress
import com.example.golddrivingschool.ui.theme.Gold
import androidx.compose.ui.tooling.preview.Preview
import com.example.golddrivingschool.ui.theme.GoldDrivingSchoolTheme

@Composable
fun ProgressScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        item {

            Text(
                text = "My Progress",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth()
            ) {

                Column(
                    modifier = Modifier.padding(25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "40%",
                        fontSize = 45.sp,
                        color = Gold,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Overall Progress"
                    )

                    Spacer(
                        modifier = Modifier.height(15.dp)
                    )

                    LinearProgressIndicator(
                        progress = { 0.40f },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }

            Spacer(
                modifier = Modifier.height(25.dp)
            )

            Text(
                text = "Driving Skills",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )

            SkillProgress(
                skill = "Vehicle Control",
                progress = 0.80f
            )

            SkillProgress(
                skill = "Parking",
                progress = 0.60f
            )

            SkillProgress(
                skill = "Road Awareness",
                progress = 0.50f
            )

            SkillProgress(
                skill = "Traffic Rules",
                progress = 0.70f
            )
        }
    }
}@Preview(showBackground = true)
@Composable
fun ProgressScreenPreview() {
    GoldDrivingSchoolTheme {
        ProgressScreen()
    }
}