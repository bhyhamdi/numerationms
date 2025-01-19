# Stage 1: Build the application
FROM bitnami/java:21 AS builder
RUN apt-get update && apt-get install -y maven && rm -rf /var/lib/apt/lists/*
WORKDIR /app
COPY . .


FROM bitnami/java:21

ENV APPLICATION_DIR="/app/target"
ENV MODULE="numeration.jar"
ENV JAVA_OPTIONS=""
ENV APPLICATION_OPTIONS=""
COPY --from=builder /app/target/$MODULE $APPLICATION_DIR/$MODULE
CMD java $JAVA_OPTIONS -jar $APPLICATION_DIR/$MODULE $APPLICATION_OPTIONS