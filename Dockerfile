# -------- BUILD STAGE --------
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar solo el pom para cachear dependencias
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Ahora sí copiar el código
COPY src ./src

# Compilar
RUN mvn -q -DskipTests package


# -------- RUNTIME STAGE --------
FROM eclipse-temurin:17-jre
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-Xms256m", "-Xmx512m", "-jar", "app.jar"]
