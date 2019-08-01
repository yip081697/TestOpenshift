
FROM openjdk:8-jre-alpine
EXPOSE 9990
ADD /target/TestHelloWorld-1.0.0-jar-with-dependencies.jar server.jar
COPY /src/main/resources/config config
COPY /src/main/resources/logback.xml logback.xml
CMD ["/bin/sh","-c","java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=1 -Dlight-4j-config-dir=/config -Dlogback.configurationFile=/config/logback.xml -jar /server.jar"]