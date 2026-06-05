FROM gradle:8.12-jdk21
WORKDIR /app
COPY . .
RUN gradle shadowJar --no-daemon && ls build/libs/
CMD sh -c "ls build/libs/ && java -jar build/libs/*.jar"
