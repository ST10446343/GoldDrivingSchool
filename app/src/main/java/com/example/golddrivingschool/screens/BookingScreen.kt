package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MenuAnchorType
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.golddrivingschool.ui.theme.GoldDrivingSchoolTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BookingScreen(
    onBack: () -> Unit
) {

    var instructor by remember {
        mutableStateOf("")
    }

    var lessonType by remember {
        mutableStateOf("")
    }

    var date by remember {
        mutableStateOf("")
    }

    var time by remember {
        mutableStateOf("")
    }

    var transmission by remember {
        mutableStateOf("")
    }

    var isInstructorExpanded by remember { mutableStateOf(false) }
    var isTransmissionExpanded by remember { mutableStateOf(false) }

    val instructorList = listOf("Leon Schuster", "John Doe", "Peter", "Michael Bvuma")
    val transmissionList = listOf("Manual", "Automatic")

    var showConfirmation by remember {
        mutableStateOf(false)
    }

    if (showConfirmation) {

        AlertDialog(

            onDismissRequest = {
                showConfirmation = false
            },

            title = {
                Text("Confirm your Booking")
            },

            text = {

                Text(
                    "Instructor: $instructor\n" +
                            "Lesson: $lessonType\n" +
                            "Date: $date\n" +
                            "Time: $time\n" +
                            "Transmission: $transmission"
                )
            },

            confirmButton = {

                TextButton(
                    onClick = {
                        com.example.golddrivingschool.data.BookingRepository.addBooking(
                            instructor = instructor,
                            lessonType = lessonType,
                            date = date,
                            time = time,
                            transmission = transmission
                        )
                        showConfirmation = false
                        onBack()
                    }
                ) {

                    Text("Confirm")
                }
            },

            dismissButton = {

                TextButton(
                    onClick = {
                        showConfirmation = false
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
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        IconButton(
            onClick = onBack
        ) {

            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back"
            )
        }

        Text(
            text = "Book a Lesson",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )
        ExposedDropdownMenuBox(
            expanded = isInstructorExpanded,
            onExpandedChange = { isInstructorExpanded = !isInstructorExpanded },
            modifier = Modifier.fillMaxWidth()
        ){

        OutlinedTextField(
            value = instructor,
            onValueChange = {},
            readOnly = true,
            label = {
                Text("Instructor")
            },
            placeholder = {
                Text("Select Instructor")
            },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isInstructorExpanded) },
            modifier = Modifier
                .menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled = true)
                .fillMaxWidth()
        )
            ExposedDropdownMenu(
                expanded = isInstructorExpanded,
                onDismissRequest = { isInstructorExpanded = false }
            ) {
                instructorList.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            instructor = selectionOption
                            isInstructorExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = lessonType,
            onValueChange = {
                lessonType = it
            },
            label = {
                Text("Lesson Types")
            },
            placeholder = {
                Text("e.g. Driving Lesson")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )
        ExposedDropdownMenuBox(
            expanded = isTransmissionExpanded,
            onExpandedChange = { isTransmissionExpanded = !isTransmissionExpanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = transmission,
                onValueChange = {},
                readOnly = true,
                label = { Text("Transmission Type") },
                placeholder = { Text("Select Manual or Automatic") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isTransmissionExpanded) },
                modifier = Modifier
                    .menuAnchor(MenuAnchorType.PrimaryNotEditable, enabled = true)
                    .fillMaxWidth()
            )
            ExposedDropdownMenu(
                expanded = isTransmissionExpanded,
                onDismissRequest = { isTransmissionExpanded = false }
            ) {
                transmissionList.forEach { selectionOption ->
                    DropdownMenuItem(
                        text = { Text(selectionOption) },
                        onClick = {
                            transmission = selectionOption
                            isTransmissionExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = date,
            onValueChange = {
                date = it
            },
            label = {
                Text("Date")
            },
            placeholder = {
                Text("e.g. 15 June 2026")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(12.dp)
        )

        OutlinedTextField(
            value = time,
            onValueChange = {
                time = it
            },
            label = {
                Text("Time")
            },
            placeholder = {
                Text("e.g. 14:00")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Button(
            onClick = {

                if (
                    instructor.isNotBlank() &&
                    lessonType.isNotBlank() &&
                    date.isNotBlank() &&
                    time.isNotBlank() &&
                    transmission.isNotBlank()
                ) {

                    showConfirmation = true
                }
            },

            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Confirm the Booking")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun BookingScreenPreview() {
    GoldDrivingSchoolTheme {
        BookingScreen(onBack = {})
    }
}