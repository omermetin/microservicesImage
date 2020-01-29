FROM java:8
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka-server.jar"]