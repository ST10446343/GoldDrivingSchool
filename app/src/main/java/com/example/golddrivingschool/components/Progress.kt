package com.example.golddrivingschool.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight

@Composable
fun SkillProgress(
    skill: String,
    progress: Float
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {

            Text(
                text = skill,
                modifier = Modifier.weight(1f)
            )

            Text(
                text = "${(progress * 100).toInt()}%",
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(
            modifier = Modifier.height(5.dp)
        )

        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier.fillMaxWidth()
        )
    }
}