package com.example.golddrivingschool.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import com.example.golddrivingschool.data.Booking
import com.example.golddrivingschool.ui.theme.SuccessGreen
import androidx.compose.ui.graphics.Color
@Composable
fun BookingCard(
    booking: Booking,
    onCancel: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

        Column(
            modifier = Modifier.padding(20.dp)
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = booking.date,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = booking.status,
                    color = if (booking.status == "Confirmed") {
                        SuccessGreen
                    } else {
                        Color.Red
                    }
                )
            }

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            Text(
                text = booking.lessonType,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Time: ${booking.time}"
            )

            Text(
                text = "Instrucctor: ${booking.instructor}"
            )

            Spacer(
                modifier = Modifier.height(10.dp)
            )

            OutlinedButton(
                onClick = onCancel
            ) {

                Text("Cancel Booking")
            }
        }
    }
}