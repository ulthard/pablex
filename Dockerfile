FROM openjdk:8-jdk-alpine
EXPOSE 8082
WORKDIR /app

ARG DATABASE_HOST
ARG DATABASE_DB
ARG DATABASE_USER
ARG DATABASE_PASSWORD

# Copy maven executable to the image
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml file
COPY pom.xml .

# Copy the project source
COPY ./src ./src
COPY ./pom.xml ./pom.xml

RUN chmod 755 /app/mvnw

RUN ./mvnw dependency:go-offline -B

RUN ./mvnw package -P prod -DskipTests

ENTRYPOINT ["java","-jar","target/pablex-0.0.1-SNAPSHOT.jar"]
