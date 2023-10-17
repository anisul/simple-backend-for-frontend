# simple-backend-for-frontend

# REST API Documentation

## Table of Contents
- [Introduction](#introduction)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Building the Project](#building-the-project)
    - [Running the API](#running-the-api)
- [API Endpoints](#api-endpoints)
    - [Get Bored Information](#get-bored-information)
- [Request and Response Examples](#request-and-response-examples)
- [Error Handling](#error-handling)
- [Testing](#testing)
- [License](#license)

## Introduction
This is the documentation for the REST API that provides information about activities based on the requester's IP address. The API is built using Gradle and designed to be simple and user-friendly.

## Getting Started
### Prerequisites
Before using this API, ensure you have the following prerequisites:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html)
- [Gradle](https://gradle.org/install/)
- A compatible web server (e.g., Apache Tomcat)
- [Bored API](https://www.boredapi.com/): The API relies on the Bored API to retrieve activity information. Ensure that the Bored API is accessible.

### Building the Project
To build the project, follow these steps:

1. Open a terminal or command prompt.
2. Navigate to the root directory of the project.
3. Run the following Gradle build command: `./gradlew build`

### Running the API
To run the API, use the following Gradle task: `./gradlew bootRun`


The API will be accessible at `http://localhost:8080`. You can modify the port in the `application.properties` file if needed.

## API Endpoints
### Get Bored Information
- **Endpoint:** `/v1/api/bored-ip/{ip}`
- **Method:** GET
- **Description:** Get information about activities based on the requester's IP address.
- **Parameters:**
    - `ip` (Path Parameter): The requester's IP address.
- **Response:** A JSON object containing details about the activity and requester information.

## Request and Response Examples
### Request
To retrieve information about activities, make a GET request to the following endpoint, replacing `{ip}` with the actual IP address:
`GET http://localhost:8080/v1/api/bored-ip/{ip}`


### Response
The response will be a JSON object with the following structure:
```json
{
  "activity": "Test Activity",
  "accessibility": 0.5,
  "requesterIp": "192.168.1.1",
  "requesterLoc": "Test Location",
  "requesterTimezone": "Test Timezone"
}
```

## Error Handling
- If an invalid or non-existent IP address is provided, the API will respond with an appropriate error message and status code.
- Error responses will include a JSON object with an error message for easy diagnosis.

## Testing
To test the API, you can use tools like **Postman**, **curl**, or your preferred HTTP client to make requests to the API endpoints. Ensure that the API is running and accessible at the base URL.

## License
This API is released under the **MIT License**, allowing you to use and modify it as needed for your purposes.

Please replace placeholders like `{ip}`, `localhost:8080`, and URLs with your actual values. Additionally, include any specific usage guidelines, rate limits, or authentication requirements if applicable to your API.
