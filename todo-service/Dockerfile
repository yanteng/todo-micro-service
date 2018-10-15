FROM anapsix/alpine-java:8
COPY ./build/libs/*SNAPSHOT.jar app.jar
COPY ./entrypoint.sh /entrypoint.sh
ENV JAVA_OPTS=""
ENV PROFILE="pro"
EXPOSE 8082
ENTRYPOINT ["sh","entrypoint.sh"]