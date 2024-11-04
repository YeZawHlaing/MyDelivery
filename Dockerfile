FROM openjdk:21-jdk-alpine

COPY target/MyDelivery-0.0.1-SNAPSHOT.jar /app.jar

WORKDIR /app

# Set the environment variable for the Firebase Service Account Key
ENV GOOGLE_APPLICATION_CREDENTIALS=./resources/nutrition-6c8ab-firebase-adminsdk-d26ze-cdb40b78b9.json

CMD ["java", "-jar", "app.jar"]