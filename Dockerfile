FROM gradle:jdk11-alpine@sha256:0c20c5771cbd452394e2d532592ff274daaaf026c4251a4b6988d31d82970e90

WORKDIR /app

# don't forget to build the project beforehand with ./gradlew clean build
COPY build .

COPY build.gradle .

RUN mkdir -p src/test/resources

RUN mv resources/test/* src/test/resources

# WIP
RUN PATH=/app/classes/java/test:$PATH

RUN export PATH

EXPOSE 3000

CMD ["gradle" , "cucumber"]