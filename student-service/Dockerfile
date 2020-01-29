FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} student-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/student-service.jar"]