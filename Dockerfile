FROM openjdk:21
COPY ./target/customerms-0.0.1-SNAPSHOT.jar /customerms.jar
CMD ["java", "-jar", "/customerms.jar"]