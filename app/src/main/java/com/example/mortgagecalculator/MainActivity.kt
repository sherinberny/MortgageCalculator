package com.example.mortgagecalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MortgageCalculatorScreen() {
    var loanAmount by remember { mutableStateOf("") }
    var termInYears by remember { mutableStateOf("") }
    var annualInterestRate by remember { mutableStateOf("") }
    var monthlyPayment by remember { mutableStateOf<String?>(null) }

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
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 24.dp)
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
            onValueChange = { if (monthlyPayment == null) loanAmount = it },
            label = { Text("Loan Amount") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number // Force numeric keyboard
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,  // Dark text color for light theme
                unfocusedTextColor = Color.Gray,
                cursorColor = Color.Black,  // Dark cursor color
                focusedBorderColor = Color.Black,  // Border color when focused
                unfocusedBorderColor = Color.Gray,  // Border color when not focused
                disabledTextColor = Color.Gray,
                disabledBorderColor = Color.Gray,
                disabledLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = monthlyPayment == null
        )

        // Term in Years Input
        OutlinedTextField(
            value = termInYears,
            onValueChange = { if (monthlyPayment == null) termInYears = it },
            label = { Text("Term (Years)") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number // Force numeric keyboard
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,  // Dark text color for light theme
                unfocusedTextColor = Color.Gray,
                cursorColor = Color.Black,  // Dark cursor color
                focusedBorderColor = Color.Black,  // Border color when focused
                unfocusedBorderColor = Color.Gray,  // Border color when not focused
                disabledTextColor = Color.Gray,
                disabledBorderColor = Color.Gray,
                disabledLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = monthlyPayment == null
        )

        // Annual Interest Rate Input
        OutlinedTextField(
            value = annualInterestRate,
            onValueChange = { if (monthlyPayment == null) annualInterestRate = it },
            label = { Text("Annual Interest Rate (%)") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number // Force numeric keyboard
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedTextColor = Color.Black,  // Dark text color for light theme
                unfocusedTextColor = Color.Gray,
                cursorColor = Color.Black,  // Dark cursor color
                focusedBorderColor = Color.Black,  // Border color when focused
                unfocusedBorderColor = Color.Gray,  // Border color when not focused
                disabledTextColor = Color.Gray,
                disabledBorderColor = Color.Gray,
                disabledLabelColor = Color.Gray
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            enabled = monthlyPayment == null
        )

        // Calculate Button
        if (monthlyPayment == null) {
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
                    .padding(vertical = 16.dp)
            ) {
                Text(text = "Calculate")
            }
        }

        // Reset Button
        if (monthlyPayment != null) {
            Button(
                onClick = {
                    loanAmount = ""
                    termInYears = ""
                    annualInterestRate = ""
                    monthlyPayment = null
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Reset")
            }

            // Display Monthly Payment
            Text(
                text = "$monthlyPayment",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier.padding(top = 16.dp),
                color = if (monthlyPayment == "Invalid Input") Color.Red else Color(0xFF556F44),  // Red for error, Green for valid result


            )
        }
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
    val df = DecimalFormat("Monthly Payment: $#.##")
    return df.format(monthlyPayment)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MortgageCalculatorTheme {
        MortgageCalculatorScreen()
    }
}
