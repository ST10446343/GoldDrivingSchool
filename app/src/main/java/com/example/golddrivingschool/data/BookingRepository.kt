package com.example.golddrivingschool.data

import androidx.compose.runtime.mutableStateListOf

object BookingRepository {

    private val _bookings = mutableStateListOf(
        Booking(
            id = "B001",
            date = "15 June 2026",
            time = "14:00",
            instructor = "Leon Schuster",
            lessonType = "Driving Lesson",
            status = "Confirmed"
        ),
        Booking(
            id = "B002",
            date = "20 June 2026",
            time = "10:00",
            instructor = "John Doe",
            lessonType = "Test Preparation",
            status = "Pending"
        )
    )

    val bookings: List<Booking> get() = _bookings

    fun addBooking(instructor: String, lessonType: String, date: String, time: String) {
        val newId = "B00${_bookings.size + 1}"
        val newBooking = Booking(
            id = newId,
            date = date,
            time = time,
            instructor = instructor,
            lessonType = lessonType,
            status = "Confirmed"
        )
        _bookings.add(newBooking)
    }

    fun removeBooking(booking: Booking) {
        _bookings.remove(booking)
    }
}