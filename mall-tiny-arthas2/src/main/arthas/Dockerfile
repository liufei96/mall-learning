# 该镜像需要依赖的基础镜像
FROM openjdk:8
# 将当前目录下的jar包复制到docker容器的/目录下
ADD arthas-tunnel-server-3.6.6.jar /arthas-tunnel-server.jar
# 声明服务运行的端口
EXPOSE 8080 7777
# 指定docker容器启动时运行jar包
ENTRYPOINT ["java", "-jar","/arthas-tunnel-server.jar"]
# 指定维护者的名字
MAINTAINER liufei