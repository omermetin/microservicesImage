FROM java
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} school-service.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/school-service.jar"]