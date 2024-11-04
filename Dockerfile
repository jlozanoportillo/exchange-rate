# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
VOLUME /tmp

# Copia el archivo JAR de tu proyecto al contenedor
COPY target/exchange-rate-0.0.1-SNAPSHOT.jar exchange-rate.jar

# Expone el puerto 8081
EXPOSE 8081

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "exchange-rate.jar"]
