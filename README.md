# jamrik-mvp
📦 JAMRIK - Automated Logistics & HS Code Assistant
Jamrik is a modern MVP solution designed to streamline logistics paper-processing. It features an intelligent AI-powered HS Code Classifier that utilizes Google Gemini to automatically identify Harmonized System codes for products based on their description.

This project utilizes a Microservices Architecture, separating the Frontend and Backend into distinct Docker containers for scalability and maintainability.

🚀 Features
🔐 User Authentication: Secure Login and Registration system.

🤖 AI-Powered Classification: Integration with Google Gemini Pro via Spring AI to generate accurate HS Codes.

🐳 Fully Dockerized: "Pull & Run" deployment using Docker Hub images.

⚡ Modern Stack: Built with Java 21, Spring Boot 3, and Vanilla JS.

🗄️ Robust Database: Persisted data storage using PostgreSQL 15.

Actions CI/CD: Automated build and push pipelines via GitHub Actions.

🛠️ Tech Stack
Backend
Language: Java 21

Framework: Spring Boot 3.4.1

AI Integration: Spring AI (Google Gemini Model)

Database: PostgreSQL 15

Security: CORS configured for frontend communication.

Frontend
Core: HTML5, CSS3, JavaScript.

Server: Nginx (Alpine Linux).

DevOps & Tools
Containerization: Docker & Docker Compose.

Registry: Docker Hub (ahmeddyasien/jamrik-backend, ahmeddyasien/jamrik-frontend).

CI/CD: GitHub Actions (Functional & Security Workflows).

🏗️ Architecture
The system consists of three main services orchestrated by Docker Compose:

Frontend (jamrik_frontend): Runs on Port 3000. Serves the UI via Nginx.

Backend (jamrik_backend): Runs on Port 8080. Handles API requests and connects to Google AI.

Database (jamrik_db): Runs on Port 5432. PostgreSQL database for user data persistence..
