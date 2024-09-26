Mortgage Calculator App
Introduction
This is a simple Mortgage Calculator app developed for Android using Kotlin and Jetpack Compose. It allows users to calculate their monthly mortgage payments based on the loan amount, term in years, and annual interest rate.

Features
User-friendly interface for inputting loan details
Calculation of monthly mortgage payments
Error handling for invalid input
Responsive design using Jetpack Compose
Requirements
Android Studio (version 4.1 or higher)
Kotlin 1.5 or higher
Jetpack Compose libraries
Getting Started
Clone the Repository
bash
Copy code
git clone https://github.com/yourusername/mortgage-calculator.git
cd mortgage-calculator
Open the Project
Open Android Studio.
Select "Open an existing project."
Navigate to the cloned repository folder and select it.
Build and Run the App
Ensure your Android device or emulator is set up.
Click on the "Run" button in Android Studio.
The app should launch on your device/emulator.
Usage
Enter the Loan Amount.
Input the Term in years.
Provide the Annual Interest Rate (as a percentage).
Tap the Calculate button.
The monthly payment will be displayed below.
Error Handling
If any input fields are left empty or contain non-numeric values, the app will display "Invalid Input" as the monthly payment.
Code Overview
The app is structured into the following main components:

MainActivity: Entry point of the app, sets the content to the MortgageCalculatorScreen.
MortgageCalculatorScreen: Composable function that contains UI elements for input and displaying the result.
calculateMortgage: Function that performs the mortgage calculation based on user input.
Screenshots
Input Screen

Output Screen

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Jetpack Compose for building the UI
Kotlin for a modern programming experience
Contact
For any questions or feedback, please reach out to Your Name.
