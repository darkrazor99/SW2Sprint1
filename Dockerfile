FROM openjdk:8-jdk-alpine
# Refer to Maven build -> finalName
ARG JAR_FILE=target/spring-boot-sw2-sprint2.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
COPY . .

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]