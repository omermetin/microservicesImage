FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} _04_student-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/_04_student-service.jar"]