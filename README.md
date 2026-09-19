# 🧑‍💼 Employee Management System — Backend

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-orange?logo=openjdk)](https://openjdk.org/projects/jdk/17/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-blue?logo=postgresql)](https://www.postgresql.org/)
[![Docker](https://img.shields.io/badge/Docker-Containerized-2496ED?logo=docker)](https://www.docker.com/)
[![AWS](https://img.shields.io/badge/AWS-Deployed-FF9900?logo=amazonaws)](https://aws.amazon.com/)
[![Firebase](https://img.shields.io/badge/Firebase-Auth-FFCA28?logo=firebase)](https://firebase.google.com/)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A **production-ready RESTful backend** for managing employee records, built with Spring Boot and PostgreSQL. Containerized with Docker, secured with Firebase Authentication, and deployed on AWS.

---

## 📋 Table of Contents

- [Features](#-features)
- [Tech Stack](#-tech-stack)
- [Project Structure](#-project-structure)
- [API Reference](#-api-reference)
- [Getting Started](#-getting-started)
  - [Prerequisites](#prerequisites)
  - [Local Setup (Without Docker)](#local-setup-without-docker)
  - [Running with Docker Compose](#running-with-docker-compose)
- [Environment Variables](#-environment-variables)
- [Deployment on AWS](#-deployment-on-aws)
- [Screenshots](#-screenshots)
- [Contributing](#-contributing)
- [License](#-license)

---

## ✨ Features

- ✅ **Full CRUD** — Create, Read, Update, and Delete employee records
- ✅ **RESTful API** — Clean, versioned endpoints under `/api/employees`
- ✅ **PostgreSQL Integration** — Persistent data storage with JPA/Hibernate
- ✅ **Firebase Authentication** — Secure, token-based auth (JWT via Firebase)
- ✅ **Docker & Docker Compose** — One-command containerized local environment
- ✅ **AWS Deployment** — Cloud-ready, deployed on AWS (EC2 / Elastic Beanstalk)
- ✅ **Lombok** — Boilerplate-free Java with auto-generated getters/setters
- ✅ **CORS Enabled** — Ready to connect with any frontend client

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 4.1.1 |
| Database | PostgreSQL 18 |
| ORM | Spring Data JPA / Hibernate |
| Auth | Firebase Authentication |
| Containerization | Docker + Docker Compose |
| Cloud | AWS (EC2 / Elastic Beanstalk) |
| Build Tool | Apache Maven |
| Utilities | Lombok |

---

## 📁 Project Structure

```
employeemanagementsystem-backend/
├── src/
│   └── main/
│       ├── java/com/example/employeemanagementsystem_backend/
│       │   ├── Controller/
│       │   │   └── EmployeeController.java   # REST API endpoints
│       │   ├── Dto/
│       │   │   └── EmployeeDto.java          # Data Transfer Objects
│       │   ├── Entity/
│       │   │   └── Employee.java             # JPA Entity (DB table)
│       │   ├── Mapper/
│       │   │   └── EmployeeMapper.java       # Entity <-> DTO mapping
│       │   ├── Repository/
│       │   │   └── EmployeeRepository.java   # Spring Data JPA repo
│       │   └── service/
│       │       ├── EmployeeService.java      # Service interface
│       │       └── Employeeserviceimpl.java  # Service implementation
│       └── resources/
│           └── application.properties        # App configuration
├── Dockerfile                                # Container image definition
├── docker-compose.yml                        # Multi-service orchestration
├── .env.example                              # Example environment variables
├── pom.xml                                   # Maven dependencies
└── README.md
```

---

## 📡 API Reference

Base URL: `http://localhost:8080/api/employees`

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| `POST` | `/api/employees` | Create a new employee | `201 Created` |
| `GET` | `/api/employees` | Get all employees | `200 OK` |
| `GET` | `/api/employees/{id}` | Get employee by ID | `200 OK` |
| `PUT` | `/api/employees/{id}` | Update employee by ID | `200 OK` |
| `DELETE` | `/api/employees/{id}` | Delete employee by ID | `200 OK` |

### Request / Response Example

**POST** `/api/employees`

```json
// Request Body
{
  "firstName": "Lokesh",
  "lastName": "Rongali",
  "email": "lokesh@example.com"
}

// Response — 201 Created
{
  "id": 1,
  "firstName": "Lokesh",
  "lastName": "Rongali",
  "email": "lokesh@example.com"
}
```

---

## 🚀 Getting Started

### Prerequisites

| Tool | Version | Download |
|------|---------|----------|
| Java JDK | 17+ | [Download](https://openjdk.org/) |
| Maven | 3.8+ | [Download](https://maven.apache.org/) |
| PostgreSQL | 14+ | [Download](https://www.postgresql.org/download/) |
| Docker | Latest | [Download](https://www.docker.com/get-started) |
| Docker Compose | Latest | Included with Docker Desktop |

---

### Local Setup (Without Docker)

**1. Clone the repository**

```bash
git clone https://github.com/your-username/employeemanagementsystem-backend.git
cd employeemanagementsystem-backend
```

**2. Create the PostgreSQL database**

```sql
CREATE DATABASE ems;
```

**3. Configure application properties**

Edit `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ems
spring.datasource.username=postgres
spring.datasource.password=your_password
```

**4. Build and run**

```bash
# Linux / macOS
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

API available at: **`http://localhost:8080`**

---

### Running with Docker Compose

> ✅ **Recommended for beginners** — no local PostgreSQL installation needed.

**1. Clone the repository**

```bash
git clone https://github.com/your-username/employeemanagementsystem-backend.git
cd employeemanagementsystem-backend
```

**2. Build the JAR**

```bash
./mvnw clean package -DskipTests
# Windows: mvnw.cmd clean package -DskipTests
```

**3. Start all services**

```bash
docker-compose up --build
```

This starts two containers:
- **`postgres-container`** — PostgreSQL 18 on port `5432`
- **`employee-management-container`** — Spring Boot API on port `8080`

**4. Stop services**

```bash
docker-compose down          # stop containers
docker-compose down -v       # stop + delete DB data
```

---

## 🔐 Environment Variables

Copy `.env.example` to `.env` and fill in your values:

```bash
cp .env.example .env
```

| Variable | Description | Default |
|----------|-------------|---------|
| `POSTGRES_DB` | Database name | `ems` |
| `POSTGRES_USER` | Database username | `postgres` |
| `POSTGRES_PASSWORD` | Database password | *(set this!)* |
| `SPRING_DATASOURCE_URL` | Full JDBC connection URL | `jdbc:postgresql://postgres:5432/ems` |
| `FIREBASE_PROJECT_ID` | Firebase project ID for auth | *(required for auth)* |

> ⚠️ **Never commit `.env` or credentials to version control.** `.gitignore` already excludes `.env`.

---

## ☁️ Deployment on AWS

### Option A — AWS EC2 (Docker)

```bash
# 1. SSH into your EC2 instance
ssh -i your-key.pem ec2-user@<YOUR_EC2_IP>

# 2. Install Docker
sudo yum update -y && sudo yum install docker -y
sudo service docker start

# 3. Run the container
docker run -d -p 8080:8080 \
  -e SPRING_DATASOURCE_URL=jdbc:postgresql://<RDS_ENDPOINT>:5432/ems \
  -e SPRING_DATASOURCE_USERNAME=postgres \
  -e SPRING_DATASOURCE_PASSWORD=yourpassword \
  your-dockerhub-username/employee-management-backend:latest
```

### Option B — AWS Elastic Beanstalk (Recommended)

1. Build: `./mvnw clean package`
2. Go to **Elastic Beanstalk → Create Application**
3. Platform: **Java** → Upload `target/*.jar`
4. Add env variables under **Configuration → Software**
5. Point database to **AWS RDS PostgreSQL**
6. Deploy 🚀

### Database — AWS RDS

Use **Amazon RDS for PostgreSQL** in production instead of a Docker container:
- Engine version: PostgreSQL 14+
- DB identifier: `ems-db`
- Update `SPRING_DATASOURCE_URL` to your RDS endpoint

---

## 📸 Screenshots

> Add screenshots by placing images in a `screenshots/` folder and linking them below.

```
screenshots/
├── postman-create-employee.png
├── postman-get-all-employees.png
├── docker-containers-running.png
└── aws-deployment.png
```

Replace this section with your actual screenshots like:

```markdown
![Create Employee](screenshots/postman-create-employee.png)
![Docker Running](screenshots/docker-containers-running.png)
```

---

## 🤝 Contributing

1. **Fork** this repository
2. **Create** a branch: `git checkout -b feature/your-feature`
3. **Commit**: `git commit -m "feat: add your feature"`
4. **Push**: `git push origin feature/your-feature`
5. **Open** a Pull Request

Please follow [Conventional Commits](https://www.conventionalcommits.org/) for commit messages.

---

## 📄 License

This project is licensed under the **MIT License** — see the [LICENSE](LICENSE) file for details.

---

<div align="center">
  <p>Built with ❤️ by <a href="https://github.com/lokeshkumarrongali">Lokesh Kumar Rongali</a></p>
  <p>⭐ Star this repo if you found it helpful!</p>
</div>
