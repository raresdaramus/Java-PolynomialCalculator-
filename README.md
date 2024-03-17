# Polynomial Calculator

## Introduction

The Polynomial Calculator is a Java application that allows performing various operations on polynomials, including addition, subtraction, multiplication, derivatives, and integrals.

## Usage

To use the Polynomial Calculator, follow these steps:

1. **Compile and Run:** Compile and run the Java application `Menu.java`.
2. **Graphical Interface:** Once the application is started, you will be greeted by a simple graphical interface that allows you to input polynomials and perform various operations on them.
3. **Inputting Polynomials:** Enter the coefficients and exponents for the polynomial terms in the corresponding fields of the graphical interface. For example: `3.3x^2 + 2x^1 - 5x^0`.
4. **Selecting Operation:** Choose the operation you want to perform on the polynomials using the available buttons for addition, subtraction, multiplication, differentiation, or integration.
5. **Displaying Result:** The result of the selected operation will be displayed in a text field, providing you with an easily readable representation of the resulting polynomial.

## Features

The Polynomial Calculator offers the following main features:

- **Addition:** Adding two polynomials `P1+P2`, resulting in a new polynomial representing the sum of the two.
- **Subtraction:** Subtracting one polynomial from another `P1-P2`, resulting in a new polynomial representing the difference of the two.
- **Multiplication:** Multiplying two polynomials `P1*P2`, resulting in a new polynomial representing the product of the two.
- **Differentiation:** Calculating the derivative of a polynomial `P1'`, resulting in a new polynomial representing the derivative of the original polynomial.
- **Integration:** Calculating the integral of a polynomial, resulting in a new polynomial representing the integral of the original polynomial. Integration is performed on the first polynomial: `P1`.

## Implementation

The Polynomial Calculator is implemented in Java and consists of several classes:

- **PolynomialParser:** This class is responsible for parsing and interpreting polynomials entered by the user as strings. It uses regular expressions to identify polynomial terms and extract coefficients and exponents.

- **Polynomial:** This class represents a polynomial and provides methods for adding terms (coefficients and exponents), as well as for displaying the polynomial in its canonical form.

- **Operations:** This class contains static methods for performing various operations on polynomials, such as addition, subtraction, multiplication, differentiation, and integration. These methods use maps to represent polynomials and perform the corresponding operations on their terms.

- **Menu:** This class contains the graphical interface of the application, which allows the user to input polynomials and perform operations on them using buttons and text fields.

# Testing

The `OperationsTest` class uses JUnit to define and execute unit tests. Each test method is decorated with the `@Test` annotation, indicating that it should be executed by JUnit.

For each test method, the obtained result is compared with the expected result using the `assertEquals` method from JUnit. If the obtained result does not match the expected result, the test will fail, and an appropriate message will be displayed.

## Usage

To run the unit tests from the `OperationsTest` class, follow these steps:

1. Ensure you have the testing configuration set up in your development environment (e.g., by setting the correct path for the JUnit libraries).
2. Run the `OperationsTest` class using a test runner, such as JUnit in your preferred IDE.
3. Observe the test results: each test will indicate whether it passed or failed and will provide details about any differences between the obtained result and the expected result.

## Tested Functionalities

The `OperationsTest` class contains several test methods, each testing a specific functionality of the `Operations` class:

- **testAddPolynomials:** Tests the correctness of adding two polynomials.
- **testSubtractPolynomials:** Tests the correctness of subtracting one polynomial from another.
- **testMultiplyPolynomials:** Tests the correctness of multiplying two polynomials.
- **testDerivative:** Tests the correctness of calculating the derivative of a polynomial.
- **testIntegration:** Tests the correctness of calculating the integral of a polynomial.
 