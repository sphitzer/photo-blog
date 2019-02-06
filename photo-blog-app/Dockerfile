FROM openjdk:8-jdk-alpine
MAINTAINER courterco
VOLUME /tmp
EXPOSE 8080
# The application's jar file
ARG JAR_FILE=target/photo-blog-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
ADD ${JAR_FILE} photo-blog.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/photo-blog.jar"]
