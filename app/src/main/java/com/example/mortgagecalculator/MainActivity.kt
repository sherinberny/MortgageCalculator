package com.example.mortgagecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mortgagecalculator.ui.theme.MortgageCalculatorTheme
import java.text.DecimalFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MortgageCalculatorTheme {
                // Main UI
                MortgageCalculatorScreen()
            }
        }
    }
}

@Composable
fun MortgageCalculatorScreen() {
    var loanAmount by remember { mutableStateOf("") }
    var termInYears by remember { mutableStateOf("") }
    var annualInterestRate by remember { mutableStateOf("") }
    var monthlyPayment by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Main heading
        Text(
            text = "Welcome",
            style = MaterialTheme.typography.headlineLarge, // Larger headline style
            modifier = Modifier.padding(bottom = 24.dp) // Extra space after the heading
        )

        // Mortgage Calculator subtitle
        Text(
            text = "Sherin's Mortgage Calculator",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "Student ID: 300364313",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Loan Amount Input
        OutlinedTextField(
            value = loanAmount,
            onValueChange = { loanAmount = it },
            label = { Text("Loan Amount") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Term in Years Input
        OutlinedTextField(
            value = termInYears,
            onValueChange = { termInYears = it },
            label = { Text("Term (Years)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Annual Interest Rate Input
        OutlinedTextField(
            value = annualInterestRate,
            onValueChange = { annualInterestRate = it },
            label = { Text("Annual Interest Rate (%)") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Calculate Button
        Button(
            onClick = {
                monthlyPayment = calculateMortgage(
                    loanAmount.toDoubleOrNull(),
                    termInYears.toIntOrNull(),
                    annualInterestRate.toDoubleOrNull()
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp) // Add elevation for a raised effect
        ) {
            Text(text = "Calculate")
        }

        // Display Monthly Payment
        Text(
            text = "Monthly Payment: $monthlyPayment",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 16.dp) // Add space before this text
        )
    }
}

// Function to calculate monthly mortgage payment
fun calculateMortgage(loanAmount: Double?, termInYears: Int?, annualInterestRate: Double?): String {
    if (loanAmount == null || termInYears == null || annualInterestRate == null) {
        return "Invalid Input"
    }

    val monthlyInterestRate = annualInterestRate / 100 / 12
    val numberOfPayments = termInYears * 12
    val monthlyPayment = (loanAmount * monthlyInterestRate) / (1 - Math.pow((1 + monthlyInterestRate), (-numberOfPayments.toDouble())))

    // Format the output to 2 decimal places
    val df = DecimalFormat("$#.##")
    return df.format(monthlyPayment)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MortgageCalculatorTheme {
        MortgageCalculatorScreen()
    }
}
