FROM openjdk
LABEL maintainer = "jas91"
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY ./target/restApi-0.0.1-SNAPSHOT.jar ./
CMD ["java", "-jar", "restApi-0.0.1-SNAPSHOT.jar"]
