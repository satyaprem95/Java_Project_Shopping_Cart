# Java_Project_Shopping_Cart

This is a simple Java project for a basic shopping cart application. It allows users to browse products, add them to a cart, apply discounts, and proceed to checkout. The application utilizes MySQL as its database backend.

## Features

Browse products: Users can view a list of available products.

Add to cart: Users can add products to their shopping cart.

Apply discounts: The application applies discounts to eligible products.

Checkout: Users can proceed to checkout to finalize their purchase.

Custom error handling: The project includes custom error handling for better user experience.

## Requirements:

To run this project, you'll need:

Java Development Kit (JDK)

MySQL database server

MySQL Connector/J (JDBC driver for MySQL)

## Installation
Clone the repository to your local machine.

Import the project into your preferred Java IDE.

Set up your MySQL database and configure the connection settings in the project.

Compile and run the application.


## Usage
Start the application.

Navigate through the available products.

Add desired products to the cart.

Apply any applicable discounts.

Proceed to checkout to finalize the purchase.

## Custom Error Handling

This project includes custom error handling to provide users with informative error messages in case of issues such as inavailability of products,  etc.

## GUI Implementation

The GUI is developed using Java's Swing framework. Here's a breakdown of the GUI components and their functionalities:

## Components:
Output Area (JTextArea): Displays messages such as item added to cart, error messages, and cart contents.

Item ComboBox (JComboBox): Dropdown menu to select items available for purchase.

Quantity Spinner (JSpinner): Allows users to select the quantity of items to add to the cart.

## Buttons:

Add to Cart: Adds the selected item with the specified quantity to the cart.

Show Cart: Displays the current contents of the shopping cart.

Clear Cart: Clears all items from the shopping cart.

Print Invoice: Prints an invoice of the items in the cart.

Exit: Exits the application.
