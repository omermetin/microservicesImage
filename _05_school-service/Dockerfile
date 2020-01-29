FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} _05_school-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/_05_school-service.jar"]