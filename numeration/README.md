# Configurable Form Builder API

This project is a Spring Boot-based backend service for managing dynamic configurations and generating forms based on those configurations. It leverages PostgreSQL, Liquibase for database migration, and Swagger for API documentation. Docker Compose is used to orchestrate the application for local development.

---

## Features

### Key Components

1. **Configuration Resource**:
   - **GET** `/api/configurations` - Fetch all configurations.
   - **POST** `/api/configurations` - Add a new configuration.

   **Configuration Structure**:
   - `name`: The name of the configuration.
   - `criteriaList`: A list of criteria defining the input fields.
     - `sortOrder`: The order of the field in the form.
     - `type`: The field type (e.g., `STRING`, `DATE`, `COMPUTER`).
     - `format`: The formatting rule for the field (e.g., `YYYY`, `0-2`).
     - `name`: The name of the field.
     - `prefix`: (Optional) A prefix for the field value.
     - `suffix`: (Optional) A suffix for the field value.

2. **Form Resource**:
   - **POST** `/api/forms` - Generate a form based on a specific configuration.

   **Form Request**:
   - `configureId`: ID of the configuration to use.
   - `fields`: List of field values to be formatted.

   Example:
   ```json
   {
     "configureId": "2a7c986f-ad90-4368-a8b1-a53196794516",
     "fields": [
       "Marc", "PASSAU", "1974/04/24"
     ]
   }
   ```

   Result:
   `Mar-PASS_1974C00003`

### Abstract and Flexible Design
The system allows:
- Defining reusable configurations.
- Generating forms dynamically based on configurations.
- Customizable input fields and formatting.

---

## Technologies Used

- **Spring Boot**: Backend framework.
- **PostgreSQL**: Database.
- **Liquibase**: Database version control and migration.
- **JUnit**: Unit testing framework.
- **Swagger**: API documentation.
- **Docker Compose**: For running the application locally.

---

## Running the Project

### Prerequisites
Ensure the following are installed:
- Docker and Docker Compose

### Steps
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd <repository-folder>
   ```

2. Start the application using Docker Compose:
   ```bash
   docker-compose up
   ```

3. Access the application:
   - **Swagger API Documentation**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

4. API Endpoints:
   - **Get All Configurations**: `GET /api/configurations`
   - **Add Configuration**: `POST /api/configurations`
   - **Post Form**: `POST /api/forms`

---

## Example Workflow

1. **Add a Configuration**
   ```json
   {
     "name": "configuration1",
     "criteriaList": [
       {
         "sortOrder": 1,
         "type": "STRING",
         "format": "0-2",
         "name": "prénom",
         "suffix": "-"
       },
       {
         "sortOrder": 2,
         "type": "STRING",
         "format": "0-3",
         "name": "nom",
         "suffix": "_"
       },
       {
         "sortOrder": 3,
         "type": "DATE",
         "format": "YYYY",
         "name": "date_de_naissance"
       },
       {
         "sortOrder": 4,
         "type": "COMPUTER",
         "format": "*5",
         "name": "compteur",
         "prefix": "C"
       }
     ]
   }
   ```

2. **Submit a Form**
   ```json
   {
     "configureId": "2a7c986f-ad90-4368-a8b1-a53196794516",
     "fields": [
       "Marc", "PASSAU", "1974/04/24"
     ]
   }
   ```

   **Output**:
   `Mar-PASS_1974C00003`

---

## Testing

Run unit tests with JUnit:
```bash
./mvnw test
```

---

## Future Enhancements
- Add support for more field types.
- Extend validation rules for configurations.
- Provide a UI for managing configurations and forms.


