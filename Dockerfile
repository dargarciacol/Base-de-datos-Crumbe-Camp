# Etapa de compilación
FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app

# Copiar primero el Maven Wrapper y el pom.xml para cachear dependencias
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN chmod +x mvnw

# Descargar dependencias (esto aísla la descarga y evita timeouts)
RUN ./mvnw dependency:go-offline -B

# Copiar el código fuente y compilar
COPY src ./src
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]