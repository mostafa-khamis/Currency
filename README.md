# Currency Exchange Application

**Idea:** A microservices-based application for currency exchange that supports service discovery and distributed tracing.

**Key Features:**
- Created two microservices with inter-service communication.
- Enabled service discovery and registration using Eureka.
- Implemented API Gateway for routing and load balancing.
- Integrated Zipkin for distributed tracing to monitor microservices interactions.
- Containerized the entire application using Docker.

**Tech Stack:** Java, Spring Boot, Spring Cloud, Eureka, API Gateway, Zipkin, Docker



**Run project on docker**
  - Add all projects in directory 
  - Open CMD in this directory 
  - Run this command "docker compose up"

URLs to test:
- http://localhost:8000/exchange/USD/to/EGP
- http://localhost:8000/exchange/USD/to/SA
- http://localhost:8000/exchange/USD/to/UAE

- http://localhost:8100/conversion/USD/to/EGP/quantity/100
- http://localhost:8100/conversion/USD/to/SA/quantity/100
- http://localhost:8100/conversion/USD/to/UAE/quantity/100

Through API Gateway 
- http://localhost:8765/CURRENCY-EXCHANGE/exchange/USD/to/EGP
- http://localhost:8765/CURRENCY-EXCHANGE/exchange/USD/to/SA
- http://localhost:8765/CURRENCY-EXCHANGE/exchange/USD/to/UAE

- http://localhost:8765/CURRENCY-CONVERSION/conversion/USD/to/EGP/quantity/100
- http://localhost:8765/CURRENCY-CONVERSION/conversion/USD/to/SA/quantity/100
- http://localhost:8765/CURRENCY-CONVERSION/conversion/USD/to/UAE/quantity/100

Eureka:
-localhost:8761
