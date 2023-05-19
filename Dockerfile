FROM maven:3.8.1-openjdk-17
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package
ARG JAR_FILE=/home/app/target/hedera-api-*.jar
RUN mv ${JAR_FILE} /home/app/app.jar
EXPOSE $PORT
ENTRYPOINT ["java","-jar","/home/app/app.jar", "--spring.profiles.active=postgres"]