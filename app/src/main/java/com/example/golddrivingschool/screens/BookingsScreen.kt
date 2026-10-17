package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
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
import com.example.golddrivingschool.components.BookingCard
import com.example.golddrivingschool.data.Booking
import androidx.compose.ui.tooling.preview.Preview
import com.example.golddrivingschool.ui.theme.GoldDrivingSchoolTheme
import com.example.golddrivingschool.data.BookingRepository
@Composable
fun BookingsScreen() {

    var selectedBooking by remember {
        mutableStateOf<Booking?>(null)
    }

    val bookings = BookingRepository.bookings

    if (selectedBooking != null) {

        AlertDialog(

            onDismissRequest = {
                selectedBooking = null
            },

            title = {
                Text("Cancel Booking")
            },

            text = {
                Text(
                    "Are you sure you want to cancel? " +
                            "booking ${selectedBooking!!.id}?"
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        BookingRepository.removeBooking(selectedBooking!!)
                        selectedBooking = null
                    }
                ) {
                    Text("Yes, Cancel")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        selectedBooking = null
                    }
                ) {
                    Text("No")
                }
            }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        item {

            Text(
                text = "My Bookings",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(
                modifier = Modifier.height(20.dp)
            )
        }

        items(bookings) { booking ->

            BookingCard(
                booking = booking,
                onCancel = {
                    selectedBooking = booking
                }
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BookingsScreenPreview() {
    GoldDrivingSchoolTheme {
        BookingsScreen()
    }
}