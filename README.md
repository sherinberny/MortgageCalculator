# Sherin's Mortgage Calculator App

## Introduction
This is a simple Mortgage Calculator app developed for Android using Kotlin and Jetpack Compose for the Mobile Application Development 2 Course as a Lab 2 assignment by Sherin Babu. It allows users to calculate their monthly mortgage payments based on the loan amount, term in years, and annual interest rate.

## Features
- **User-friendly interface** for inputting loan details.
- **Calculation of monthly mortgage payments**.
- **Error handling** for invalid input.
- **Responsive design** using Jetpack Compose.
- **Color-coded output** for better user experience:
   - Invalid input messages displayed in **red**.
   - Calculated amounts displayed in **green**.
- **Reset functionality** to clear inputs and results.

## Requirements
- **Android Studio** (version 4.1 or higher)
- **Kotlin** (version 1.5 or higher)
- **Jetpack Compose libraries**

## Getting Started

### Clone the Repository
1. Open your terminal.
2. Run the following commands:
    ```bash
    git clone https://github.com/sherinberny/MortgageCalculator.git
    cd mortgage-calculator
    ```

### Open the Project
1. Open **Android Studio**.
2. Select **"Open an existing project."**
3. Navigate to the cloned repository folder and select it.

### Build and Run the App
1. Ensure your Android device or emulator is set up.
2. Click on the **"Run"** button in Android Studio.
3. The app should launch on your device/emulator.

## Usage
1. **Enter the Loan Amount**.
2. **Input the Term in Years**.
3. **Provide the Annual Interest Rate** (as a percentage).
4. **Tap the Calculate button**.
5. The **monthly payment** will be displayed below.
6. If invalid input is detected, **"Invalid Input"** will be displayed in **red**.
7. **Tap the Reset button** to clear all fields and results.

## Error Handling
- If any input fields are left empty or contain non-numeric values, the app will display **"Invalid Input"** in **red** as the monthly payment.

## Code Overview
The app is structured into the following main components:
- **MainActivity**: Entry point of the app, sets the content to the `MortgageCalculatorScreen`.
- **MortgageCalculatorScreen**: Composable function that contains UI elements for input and displaying the result.
- **calculateMortgage**: Function that performs the mortgage calculation based on user input.

## License
This project is licensed under the MIT License - see the [LICENSE](https://www.linkedin.com/in/sherin-babu-2907/) file for details.

## Acknowledgments
- **Jetpack Compose** for building the UI.
- **Kotlin** for a modern programming experience.

## Contact
For any questions or feedback, please reach out to [**Sherin Babu**](mailto:babus5@student.douglascollege.ca).
