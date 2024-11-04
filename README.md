# Proyecto Exchange Rate API

Este es un proyecto de **Spring Boot** que proporciona una API para la conversión de tasas de cambio de divisas. El proyecto está dockerizado y se puede construir y ejecutar utilizando **Maven**.

## Requisitos Previos

Antes de ejecutar el proyecto, asegúrate de tener instalados los siguientes requisitos:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven](https://maven.apache.org/download.cgi)
- [Docker](https://www.docker.com/get-started)

## Construcción del Proyecto

Para construir el proyecto, sigue estos pasos:

1. **Clona el repositorio:**

   ```bash
   git clone https://github.com/jlozanoportillo/exchange-rate.git
   cd exchange-rate

2. **Construye el proyecto con maven:**
   ```bash
   mvn clean install

3. **Crear la imagen de Docker:**
   ```bash
   docker build -t exchange-rate-app .

4. **Ejecutar el contenedor de Docker:**
   ```bash
   docker run -p 8082:8081 exchange-rate-app


5. **Acceder a la aplicación:**
Ahora puedes acceder a la aplicación y sus endpoints a través de Postman o cualquier otro cliente HTTP.

> **Health Check**
Puedes verificar que la aplicación esté funcionando correctamente accediendo a:
   http://localhost:8081/exchange/health
   
   
   