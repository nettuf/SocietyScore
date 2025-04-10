# Etapa 1: Build do projeto usando Maven
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o projeto Maven inteiro
COPY . .

# Executa o build e ignora os testes
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final enxuta com o JAR apenas
FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

# Copia o JAR gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
