# Herbarium

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:

```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8070/q/dev/.


## Docker image setup

1.  Inside project directory run **./mvnw package**
2.  run **docker build -f src/main/docker/Dockerfile.jvm -t quarkus/herbarium-jvm .**
3.  run **docker run -i --rm -p 8070:8070 quarkus/herbarium-jvm**
 

## Backend TechStack

1.  Java Quarkus microprofiler
2.  Docker
3.  AWS S3
