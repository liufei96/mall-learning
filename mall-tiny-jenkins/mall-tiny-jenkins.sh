#!/usr/bin/env bash
app_name='mall-tiny-jenkins'
profile_active='qa'
version='1.0'
docker stop ${app_name}
echo '----stop container----'
docker rm ${app_name}
echo '----rm container----'
docker run -p 8088:8088 --name ${app_name} \
--net mall-docker-compose_default \
--link mysql:db \
-e 'spring.profiles.active'=${profile_active} \
-v /etc/localtime:/etc/localtime \
-v /mydata/app/${app_name}/logs:/var/logs \
-d localhost:5000/mall-tiny/${app_name}:${version}
echo '----start container----'