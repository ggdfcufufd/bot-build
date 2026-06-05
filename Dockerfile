FROM gradle:8.12-jdk21
WORKDIR /app
COPY . .
RUN gradle shadowJar --no-daemon
CMD sh -c "java -jar build/libs/bot-build-1.0.0.jar"
