package com.example.golddrivingschool.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.golddrivingschool.data.BookingRepository
import com.example.golddrivingschool.ui.theme.SuccessGreen

@Composable
fun PaymentsScreen(
    onBack: () -> Unit
) {
    var balance = BookingRepository.outstandingBalance
    var successMessage by remember { mutableStateOf("") }

    val transactionHistory = listOf(
        Transaction("10 May 2026", "Lesson Fee - Driving Session", "-R350", SuccessGreen),
        Transaction("01 May 2026", "Bank Deposit (Payment)", "+R1200", SuccessGreen)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Payments & Billing",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Outstanding Balance",
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "R$balance",
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        if (balance > 0) {
                            BookingRepository.clearBalance()
                            successMessage = "Payment successful! Balance cleared."
                        } else {
                            successMessage = "Account is already fully paid up."
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Pay Outstanding Balance")
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (successMessage.isNotBlank()) {
            Text(
                text = successMessage,
                color = SuccessGreen,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 10.dp)
            )
        }

        Text(
            text = "Transaction History",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(10.dp))


        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(transactionHistory) { transaction ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = androidx.compose.foundation.layout.Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text(text = transaction.title, fontWeight = FontWeight.Bold)
                            Text(text = transaction.date, fontSize = 12.sp, color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                        }
                        Text(
                            text = transaction.amount,
                            fontWeight = FontWeight.Bold,
                            color = transaction.amountColor
                        )
                    }
                }
            }
        }
    }
}

data class Transaction(
    val date: String,
    val title: String,
    val amount: String,
    val amountColor: androidx.compose.ui.graphics.Color
)