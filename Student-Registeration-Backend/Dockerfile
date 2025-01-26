# Step 1: Use a base image with JDK
FROM openjdk:17-jdk-slim as build

# Step 2: Set the working directory in the container
WORKDIR /app

# Step 3: Copy the jar file from the target folder to the container's /app folder
COPY target/student-management-system-0.0.1-SNAPSHOT.jar student-management-system.jar

# Step 4: Expose port 8080 for the application to run on
EXPOSE 8080

# Step 5: Run the jar file
ENTRYPOINT ["java", "-jar", "student-management-system.jar"]
