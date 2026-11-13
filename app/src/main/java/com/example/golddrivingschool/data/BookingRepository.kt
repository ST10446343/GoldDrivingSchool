package com.example.golddrivingschool.data

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


object BookingRepository {

    private val _bookings = mutableStateListOf(
        Booking(
            id = "B001",
            date = "15 June 2026",
            time = "14:00",
            instructor = "Leon Schuster",
            lessonType = "Driving Lesson",
            transmission = "Manual",
            status = "Confirmed"
        ),
        Booking(
            id = "B002",
            date = "20 June 2026",
            time = "10:00",
            instructor = "John Doe",
            lessonType = "Test Preparation",
            transmission = "Automatic",
            status = "Pending"
        )
    )

    val bookings: List<Booking> get() = _bookings

    var outstandingBalance by mutableIntStateOf(850)
        private set

    fun addBooking(instructor: String, lessonType: String, date: String, time: String, transmission: String) {
        val newId = "B00${_bookings.size + 1}"
        val newBooking = Booking(
            id = newId,
            date = date,
            time = time,
            instructor = instructor,
            lessonType = lessonType,
            transmission = transmission,
            status = "Confirmed"
        )
        _bookings.add(newBooking)
        outstandingBalance += 350
    }

    fun removeBooking(booking: Booking) {
        if(_bookings.remove(booking)) {
            outstandingBalance = (outstandingBalance - 350).coerceAtLeast(0)
        }
    }
    fun clearBalance(){
        outstandingBalance = 0
    }
}