FROM openjdk:8
# 指定维护者的名字
MAINTAINER liufei

ADD mall-tiny-docker-compose-1.0.jar /mall-tiny-docker-compose-1.0.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar","/mall-tiny-docker-compose-1.0.jar", "--spring.profiles.active=prod"]