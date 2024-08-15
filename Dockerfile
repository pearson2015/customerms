FROM openjdk:17
COPY ./target/customerms.jar /customerms.jar
CMD ["java", "-jar", "/customerms.jar"]