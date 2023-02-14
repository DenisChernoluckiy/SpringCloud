FROM openjdk:17-alpine
EXPOSE 8888
ADD build/libs/spring-config-server-1.jar spring-config-server-1.jar
ENTRYPOINT ["java","-jar","spring-config-server-1.jar"]
