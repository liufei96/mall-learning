
## 1. 首先启动mysql

```shell
docker run --name mysql -p 3306:3306 --restart=always -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
```

## 2. 然后运行 run.sh 脚本

## 3. 注意
1. 如果你用的mysql-connector-java是5.x的版本，则数据库链接需要加上useSSL=false，否则会出错。
详细请参考：https://blog.csdn.net/L_it123/article/details/106845391