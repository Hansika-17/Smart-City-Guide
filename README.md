
# Smart City Guide

Smart City Guide is a Java Full Stack web application designed to provide users with a centralized platform for exploring city-related information such as hotels, restaurants, events, and other travel-related services.

The application combines a Spring Boot backend, MySQL database, REST APIs, frontend components, and an AI-powered Travel Assistant to provide both structured information and natural-language assistance.

## Features

- City information and travel assistance
- Hotel search and filtering
- Restaurant search and filtering
- Event-related information
- AI-powered Travel Assistant
- Natural-language query processing
- Intelligent query routing
- Gemini API integration
- Database-backed services
- RESTful backend APIs
- Frontend and backend integration
- Collaborative Git and GitHub development

## AI Travel Assistant

The Smart City Guide includes an AI-powered Travel Assistant that allows users to interact with the application using natural-language queries.

Instead of manually selecting multiple filters, users can describe what they are looking for in a conversational way.

### Example Queries

- "Find hotels in Hyderabad under 3000"
- "Suggest restaurants in Hyderabad"
- "Find restaurants in Hyderabad under 1000"
- "What events are happening in Hyderabad?"
- "Suggest places to visit in Hyderabad"
- "Plan a weekend trip to Hyderabad"

The assistant processes the user's query and determines the appropriate way to handle the request.

For application-specific queries, the assistant can identify relevant parameters such as:

- Service type
- City
- Budget
- Event-related requirements
- Other supported filters

These parameters can then be used with the application's existing backend services to retrieve structured results.

For general travel-related queries that are not directly handled by the application's structured services, the assistant can use the Gemini API to generate an appropriate response.

## AI Query Routing

The AI Assistant follows a hybrid routing approach that combines application-specific backend functionality with generative AI.

```text
                    User Query
                         |
                         v
              AI Assistant REST API
                         |
                         v
                Query Processing
                         |
                         v
              Intent / Parameter
                  Detection
                         |
              +----------+----------+
              |                     |
              v                     v
       Structured Query       General Query
              |                     |
              v                     v
      Application Services      Gemini API
              |                     |
              +----------+----------+
                         |
                         v
                  Final Response
                         |
                         v
                        User
```

For example:

```text
"Find hotels in Hyderabad under 3000"
```

can be interpreted as:

```text
Service  -> Hotel
City     -> Hyderabad
Budget   -> 3000
```

The extracted information can then be used to construct a request to the corresponding backend service.

A general query such as:

```text
"Suggest a weekend itinerary for Hyderabad"
```

can instead be handled through the Gemini API.

This hybrid architecture allows the application to combine deterministic database-backed results with generative AI capabilities.

## AI Assistant API

The AI Assistant provides a REST endpoint for processing natural-language requests.

### Endpoint

```text
POST /api/ai/chat
```

### Example Request

```json
{
  "message": "Find hotels in Hyderabad under 3000"
}
```

The backend processes the request, determines the appropriate query route, communicates with the required service or Gemini API, and returns the response to the frontend.

## Application Architecture

The application follows a layered full-stack architecture.

```text
                         Frontend
                     HTML / CSS / JS
                           |
                           v
                     REST APIs
                           |
                           v
                    Spring Boot
                           |
          +----------------+----------------+
          |                |                |
          v                v                v
       Hotels         Restaurants         Events
          |                |                |
          +----------------+----------------+
                           |
                           v
                         MySQL

                           +

                     AI Assistant
                           |
                           v
                      Gemini API
```

## Technology Stack

### Backend

- Java
- Spring Boot
- Spring Web
- REST APIs

### Database

- MySQL

### AI

- Gemini API
- Natural-language query processing
- Intelligent query routing

### Frontend

- HTML
- CSS
- JavaScript

### Development Tools

- Git
- GitHub
- IntelliJ IDEA / VS Code
- Postman
- Swagger / OpenAPI

## Project Structure

```text
Smart-City-Guide/
|
+-- src/
|   +-- main/
|   |   +-- java/
|   |   |   +-- ...
|   |   |
|   |   +-- resources/
|   |       +-- application.properties
|   |       +-- ...
|   |
|   +-- test/
|
+-- frontend/
|   +-- ...
|
+-- pom.xml
+-- README.md
```

The exact package and directory structure may vary depending on the current development branch.

## Backend Components

### Controllers

Controllers handle incoming HTTP requests and expose REST endpoints for the frontend and other clients.

### Services

Service components contain application logic and coordinate operations between controllers, repositories, external APIs, and other application components.

### Database Layer

The database layer handles interaction with MySQL and provides persistent storage for application information.

### AI Assistant

The AI Assistant is responsible for:

- Receiving natural-language queries
- Processing user intent
- Identifying supported parameters
- Routing application-specific queries
- Communicating with application services
- Integrating with the Gemini API
- Preparing responses for the frontend

## Database

The application uses MySQL for persistent storage.

The database contains structured information required by the application's services, including information related to hotels, restaurants, events, and other application-specific data.

## Gemini API Integration

The AI Travel Assistant uses the Gemini API to provide generative AI functionality.

Gemini integration can be used for:

- General travel-related queries
- Natural-language assistance
- AI-generated responses
- Query understanding
- Travel recommendations

The Spring Boot backend communicates with the Gemini API and processes the returned response before sending it to the frontend.

## Configuration

Sensitive credentials such as API keys and database passwords should never be committed to the repository.

The Gemini API key should be provided through an environment variable.

Example `application.properties` configuration:

```properties
gemini.api.key=${GEMINI_API_KEY}
gemini.api.url=YOUR_GEMINI_API_URL
```

### Windows PowerShell

```powershell
$env:GEMINI_API_KEY="YOUR_API_KEY"
```

### Linux / macOS

```bash
export GEMINI_API_KEY="YOUR_API_KEY"
```

Do not replace `${GEMINI_API_KEY}` with the actual API key inside `application.properties`.

## Database Configuration

Configure the MySQL connection according to the local environment.

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/YOUR_DATABASE
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

Never commit real database credentials to the repository.

## Setup

### Prerequisites

- Java JDK
- Maven
- MySQL
- Git
- IntelliJ IDEA or VS Code

### Clone the Repository

```bash
git clone <REPOSITORY_URL>
cd Smart-City-Guide
```

### Configure MySQL

Create the required database and configure the database connection in `application.properties`.

Example:

```sql
CREATE DATABASE smart_city_guide;
```

### Configure Gemini API

Set the Gemini API key as an environment variable.

Windows PowerShell:

```powershell
$env:GEMINI_API_KEY="YOUR_API_KEY"
```

Linux / macOS:

```bash
export GEMINI_API_KEY="YOUR_API_KEY"
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The application can also be started by running the main Spring Boot application class from an IDE.

## API Documentation

If Swagger / OpenAPI is enabled, the available REST endpoints can be explored through Swagger UI.

Typical development URL:

```text
http://localhost:8080/swagger-ui/index.html
```

## Example Queries

### Hotel Queries

```text
Find hotels in Hyderabad
```

```text
Find hotels in Hyderabad under 3000
```

```text
Show me budget hotels in Hyderabad
```

### Restaurant Queries

```text
Find restaurants in Hyderabad
```

```text
Suggest restaurants in Hyderabad under 1000
```

```text
Find restaurants for a group in Hyderabad
```

### Event Queries

```text
What events are happening in Hyderabad?
```

```text
Find events in Hyderabad
```

### General Travel Queries

```text
What are the best places to visit in Hyderabad?
```

```text
Suggest a weekend itinerary for Hyderabad
```

```text
What can I do in Hyderabad this weekend?
```

## Frontend Integration

The frontend communicates with the Spring Boot backend through REST APIs.

```text
User
 |
 v
Frontend Interface
 |
 | HTTP Request
 v
Spring Boot REST API
 |
 v
Application Logic
 |
 +----------+----------+
 |                     |
 v                     v
MySQL                Gemini API
 |                     |
 +----------+----------+
            |
            v
       JSON Response
            |
            v
         Frontend
            |
            v
           User
```

## Testing

The application's REST APIs can be tested using:

- Postman
- Swagger UI
- Frontend interface
- IDE-based testing

Example:

```http
POST /api/ai/chat
Content-Type: application/json
```

Request body:

```json
{
  "message": "Find hotels in Hyderabad under 3000"
}
```

Testing can verify:

- API availability
- Request validation
- Database connectivity
- Query routing
- Gemini API integration
- Response formatting
- Frontend-backend communication

## Git Workflow

The project uses Git and GitHub for version control and collaborative development.

Development work is organized across feature and integration branches.

```text
main
 |
 +-- Feature Branches
 |
 +-- AI Assistant
 |
 +-- Hotel / Restaurant Module
 |
 +-- Authentication
 |
 +-- Other Application Features
```

## Security

The following information must not be committed to GitHub:

- API keys
- Database passwords
- Service account credentials
- Access tokens
- Authentication secrets

Environment variables or secure configuration mechanisms should be used for sensitive values.

If a credential is accidentally exposed:

1. Revoke or rotate the credential immediately.
2. Replace the credential in the application.
3. Remove the secret from the current source files.
4. Check Git history for previous exposure.
5. Review service usage for unauthorized activity.
6. Update all applications using the compromised credential.

Removing a secret from the latest version of a repository does not remove it from Git history.

## Screenshots and Demo

Add application screenshots here, such as:

- Home Page
- Hotel Search
- Restaurant Search
- Event Search
- AI Travel Assistant
- AI Query Results

Example:

```markdown
![Home Page](screenshots/home-page.png)
```

## Future Enhancements

- Advanced natural-language query understanding
- More hotel and restaurant filters
- Personalized travel recommendations
- Improved event discovery
- Real-time information integration
- Personalized user profiles
- Enhanced recommendation algorithms
- Support for additional cities
- Improved mobile responsiveness
- Enhanced conversational AI capabilities
- Integration with additional travel services

## Learning Outcomes

This project provides practical experience in:

- Java development
- Spring Boot
- REST API development
- MySQL database integration
- Full-stack application development
- Git and GitHub collaboration
- External API integration
- Generative AI integration
- Natural-language query processing
- Backend architecture
- Frontend-backend communication
- Software project collaboration

## Project Highlights

Smart City Guide demonstrates how a traditional full-stack application can be enhanced with generative AI.

```text
Java
   +
Spring Boot
   +
REST APIs
   +
MySQL
   +
Frontend Development
   +
External API Integration
   +
Generative AI
   +
Natural-Language Query Routing
   =
Smart City Guide
```

The AI Travel Assistant provides a conversational layer over structured application services, allowing users to interact with the platform using natural language while continuing to leverage the application's existing backend functionality.

## Team

Smart City Guide was developed as a collaborative Java Full Stack project.

The project involved contributors working across different areas of the application, including:

- Backend development
- Frontend development
- Database integration
- Authentication
- Hotel and restaurant services
- AI Assistant integration
- Testing
- Application integration

Individual contributions can be viewed through the repository's Git history and contributor information.

## Repository

GitHub Repository:
https://github.com/Hansika-17/Smart-City-Guide


## License

This project was developed for educational and academic purposes.

An appropriate open-source license can be added if the project is intended for public reuse.

## Acknowledgements

This project was developed as part of a Java Full Stack Capstone Project and makes use of technologies, frameworks, APIs, and tools from the developer ecosystem.
