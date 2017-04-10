FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/answer42-server.jar /answer42-server/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/answer42-server/app.jar"]
