# 1. 构建 mall-tiny/mall-tiny-docker-compose:1.0 镜像
将Dockerfile文件和 mall-tiny-docker-compose-1.0.jar 文件 copy到指定目录下
如：/root/docker/mall-docker-compose
```shell
docker build -t mall-tiny/mall-tiny-docker-compose:1.0 .
```

# 执行docker-compose命令
将docker-compose.yml 文件也COPY到 /root/docker/mall-docker-compose 目录下
```shell
# -d 是后台运行
# 因为yml文件名是 docker-compose.yml 文件所以不用指定，如果不是这个名字，使用 -f 指定文件
docker-compose up -d
```