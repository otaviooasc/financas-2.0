# -------------------------
# 1️⃣ Etapa de build
# -------------------------
FROM eclipse-temurin:25-jdk AS build

WORKDIR /app

# Instala Maven manualmente (já que não há imagem oficial maven:... com JDK 25)
RUN apt-get update && apt-get install -y maven

COPY . .

RUN mvn clean package -DskipTests


# -------------------------
# 2️⃣ Etapa de execução
# -------------------------
FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
