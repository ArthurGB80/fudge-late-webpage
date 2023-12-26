# Table of Contents

- [Project Overview](#project-overview)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)
- [Features](#features)
- [Architecture](#architecture)
- [Development Environment Setup](#development-environment-setup)
- [Testing](#testing)
- [Deployment](#deployment)

# Project Overview

This project provides an online marketplace for the Fudge Late Bakery. It allows customers to browse through the menu, place orders, and manage their account details. For the bakery, it provides tools for managing inventory, tracking orders, and customer interactions.

# Installation

To get started with the project, clone the repository and follow these steps:

- Install Node.js and npm if they are not installed on your machine. You can download them from the official Node.js website.
- Navigate to the project root directory in your terminal and run `npm install` to install the necessary dependencies.
- To start the application, run `ng serve`.

# Usage

Once the application is running, you can access it by navigating to http://localhost:4200/ in your web browser. From here, you can navigate through the website, browse the menu, add items to your cart, and checkout.

# Contributing

We welcome contributions from the community. If you have any suggestions or want to contribute to the development of this project, please feel free to fork the repository and submit a pull request.

# License

This project is licensed under the MIT License - see the LICENSE file for details.

# Features

Our application leverages the power of Angular and Quarkus to provide a robust and efficient online marketplace. Here are some of the key features:

- Modular Design: Our application follows a modular structure, breaking down the functionality into different components. This makes it easy to understand and maintain the codebase.
- Responsive User Interface: The application provides a responsive user interface that works well on both desktop and mobile devices.
- Real-time Updates: The application uses real-time updates to keep the user informed about the status of their orders.
- User Authentication: The application includes user authentication to secure user data and personalize the user experience.

# Architecture

Our application follows a modular structure, breaking down the functionality into different components. Here's a brief overview of the key parts of the application:

- **app**: This is the core module of the application. It contains the main component (app.component.ts) and the routing module (app-routing.module.ts). The application's layout and main logic reside here.
- **account**: This module handles everything related to user accounts, including registration and account management.
- **cart**: This module manages the shopping cart functionality, allowing users to add items to their cart and proceed to checkout.
- **checkout**: This module handles the checkout process, taking care of order placement and payment processing.
- **contact**: This module provides a way for users to reach out to the bakery with any questions or concerns.
- **home**: This module displays the home page of the application, showcasing featured products and promotional content.
- **product-management**: This module handles all operations related to managing products in the bakery's inventory.
- **services**: This module contains various services that are used across the application, such as the cart service and the products service.
- **shared**: This module contains common elements that are used throughout the application, such as shared components and utilities.
- **assets**: This directory holds static assets like images and videos used in the application.

Each of these modules or components has its own responsibility, making it easier to understand and maintain the codebase. They communicate with each other via services and events, following Angular's recommended practices for building scalable applications.

# Development Environment Setup

Before you can start developing, ensure you have the following installed:

- Node.js and npm: These are essential for managing JavaScript packages and running scripts.
- Angular CLI: This is a command line interface for Angular. It's used to create projects, generate application and library code, and perform a variety of ongoing development tasks such as testing, bundling, and deployment.
- PostgreSQL: Since our application uses a PostgreSQL database, you'll need to have this installed and running.

Once you have these prerequisites, you can clone the repository and install the necessary dependencies by running `npm install` in the project root directory.

# Testing

Our application uses Jasmine and Karma for unit testing. Run `ng test` to execute the unit tests. We also encourage writing end-to-end tests for critical user flows using Protractor.

# Deployment

The application can be deployed on any server that supports Node.js. After building the application with `ng build`, the output can be served using any static file server.
