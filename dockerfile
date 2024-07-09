# Use uma imagem base do JDK
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e a pasta src para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Baixa as dependências e constrói o projeto
RUN ./mvnw dependency:resolve
RUN ./mvnw clean package

# Expõe a porta 8080
EXPOSE 8080

# Define o comando de entrada
CMD ["java", "-jar", "target/tasklist-api-0.0.1-SNAPSHOT.jar"]
