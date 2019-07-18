FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/ghostgame-api-0.0.1-SNAPSHOT.jar ghostgame.jar
COPY src/main/resources/gosthGameDict.txt /tmp/gosthGameDict.txt

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/ghostgame.jar"]