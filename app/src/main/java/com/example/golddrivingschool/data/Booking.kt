package com.example.golddrivingschool.data

data class Booking(
    val id: String,
    val date: String,
    val time: String,
    val instructor: String,
    val lessonType: String,
    val transmission: String,
    val status: String
)
