FROM anapsix/alpine-java:8
COPY ./build/libs/*SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENV PROFILE="pro"
EXPOSE 8888
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar /app.jar"]