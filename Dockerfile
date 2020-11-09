FROM adoptopenjdk/openjdk8
VOLUME /tmp
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/zooAssessmentEurail-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 9081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dspring.profiles.active=container", "-jar", "/app/app.jar"]