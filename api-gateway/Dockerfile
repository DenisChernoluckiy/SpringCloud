FROM openjdk:17-oracle
COPY build/libs/*jar app.jar
ENV JAVA_OPTS=""
EXPOSE 8765
ADD build/libs/api-gateway-0.0.1-SNAPSHOT.jar api-gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/api-gateway-0.0.1-SNAPSHOT.jar"]
