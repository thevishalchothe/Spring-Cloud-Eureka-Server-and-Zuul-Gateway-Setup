# Spring Cloud Eureka Server and Zuul Gateway Setup 🛠️

This project demonstrates a **microservices architecture** using **Eureka Server** for service discovery and **Zuul Gateway** for API routing. It highlights how to set up and configure both components in a **Spring Boot** application.

---

## **🌐 Eureka Discovery Server**
Eureka Server is a service registry provided by Netflix, designed for service discovery in a microservices architecture. It enables microservices to dynamically discover and communicate with each other.

### **✨ Key Features**
- **📦 Service Registry**: Stores metadata about registered services, including their host, port, and status.
- **🌐 High Availability**: Supports replication and clustering for fault tolerance.
- **🛡️ Health Monitoring**: Periodically checks the health status of registered services.
- **📊 Dynamic Scaling**: Automatically updates the service registry when instances are added or removed.
- **🔄 Scalability**: Eureka enables the system to scale easily by allowing new services to register dynamically and be discovered by other services.
- **⚡ Fault-Tolerance**: Eureka's service registry helps ensure that if a service goes down, it can be discovered and routed to another available instance of the service.
- **🔗 Decoupling**: By separating the service discovery logic from the application, Eureka promotes loose coupling between services, making the architecture more maintainable and flexible.
- **📊 Centralized Management**: Eureka provides a central place to monitor the health and status of all services in the architecture.

### **⚙️ How It Works**
1. **📢 Registration**: Microservices register themselves with the Eureka Server.
2. **🔎 Discovery**: Clients query Eureka Server to retrieve the list of active instances for a specific service.
3. **💾 Heartbeats**: Services send periodic heartbeats to confirm their availability.

### **💡 Setup in Spring Boot**
1. Add the dependency:
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
   </dependency>
   ```
2. Enable Eureka Server:
   ```java
   @SpringBootApplication
   @EnableEurekaServer
   public class EurekaServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(EurekaServerApplication.class, args);
       }
   }
   ```
3. **#Configure the application in application.properties**

#The application name for Eureka Server
- spring.application.name=eureka-server

#Setting the server port for the Eureka Server 
- server.port=8762

#Setting the Eureka client to not fetch the registry because this is the Eureka Server, not a client
- eureka.client.fetch-registry=false

#The server shouldn't register itself with Eureka (as it is a server)
- eureka.client.register-with-eureka=false

#Eureka server URL for other services to register with. This is pointing to itself in this case
- eureka.server.service-url.defaultZone=http://localhost:8762/eureka/

---

## **🌐 Zuul API Gateway**

Zuul is an API Gateway developed by Netflix, which acts as a single entry point for routing client requests to various microservices. It provides features like routing, monitoring, security, and load balancing, acting as a mediator between the client and backend services.


### **✨ Key Features**
- **🔄 Dynamic Routing**: Zuul routes incoming requests to the appropriate microservice based on configuration.
- **🔒 Security**: It provides a layer of security for the microservices, including authentication and authorization.
- **🔄 Load Balancing**: Zuul can distribute client requests across multiple instances of a service, enhancing scalability and reliability.
- **📊 Monitoring and Logging**: Tracks and logs all requests and responses, offering visibility into system performance and issues.
- **📊 Scalability**: Zuul provides efficient routing, helping balance the load and scale the application as needed.
- **⚡ Fault-Tolerance**: Zuul provides failover capabilities, enabling continuous service availability even in case of failures.
- **🔗 Decoupling**: By separating the API routing from microservices, Zuul promotes loose coupling between services and simplifies service-to-service communication.
- **🔄 Dynamic Routing**: Zuul dynamically routes requests to different services based on the request's path, enabling seamless interaction with microservices without hardcoded service locations.
- **📊 Centralized Management**: Zuul simplifies managing API endpoints and request routing for the client, reducing the complexity of frontend communication with microservices.

## ⚙️ How It Works
1. **🚪 Request Forwarding**: Zuul intercepts incoming HTTP requests and forwards them to the target service based on the configuration.
2. **🔎 Service Discovery Integration**: Zuul integrates with Eureka Server to dynamically route requests to registered services, ensuring up-to-date information on available services.
3. **💨 Load Balancing**: Through integration with Ribbon, Zuul can distribute requests to different instances of a service, improving load distribution and fault tolerance.
4. **📜 Filters**: Zuul uses filters to handle pre-routing, post-routing, error handling, and security logic, offering flexibility in request processing.
### **💡 Setup in Spring Boot**
1. Add the dependency:
   ```xml
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-netflix-zuul</artifactId>
   </dependency>
   ```
2. Enable Zuul Server:
   ```java
   @SpringBootApplication
   @EnableZuulProxy
   public class ZuulServerApplication {
       public static void main(String[] args) {
           SpringApplication.run(ZuulServerApplication.class, args);
       }
   }
   ```
3. **#Configure the application in application.properties**

#Setting the server port for the Zuul Gateway
- server.port=8763

#The application name for the Zuul Gateway
- spring.application.name=zuul-gateway

#Eureka server URL for the Zuul Gateway to register with Eureka
- eureka.client.service-url.defaultZone=http://localhost:8762/eureka/

#Define the route for the "adm" service, pointing to a specific URL or service in the system

#Uncomment and update the routes below as per your services (eg.)

#zuul.routes.adm.url=http://localhost:8081  # If you want to route traffic to a specific URL

#zuul.routes.adm.service-id=admission  # If the "admission" service is registered in Eureka

---

## 🎨 Microservices Architecture Overview

- **🌐 Eureka Discovery Server** acts as the service registry for microservices, allowing them to register and discover each other.
- **🌐 Zuul API Gateway** serves as the entry point for client requests, handling routing and forwarding requests to the appropriate microservices.

This setup ensures a **scalable**, **fault-tolerant**, and **efficient** microservices architecture, with **centralized service discovery** (Eureka) and **dynamic request routing** (Zuul).

  - Microservices register with the **Eureka Discovery Server**, and the **Zuul API Gateway** dynamically routes requests to these services based on the client’s request.
