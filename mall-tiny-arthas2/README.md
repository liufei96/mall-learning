## arthas 参考资料
https://arthas.aliyun.com/doc/tunnel.html
https://github.com/alibaba/arthas

## 注意：
1. 先启动springBoot服务，然后再启动arthas-tunnel-server-3.6.6.jar 服务。arthas-tunnel服务启动之后，日志中会打印密码
```shell
2022-09-17 16:08:02.402  WARN 26136 --- [           main] .s.s.UserDetailsServiceAutoConfiguration : 

Using generated security password: f3097e20-5c8a-4f43-bb0d-79ba5d4fa872

This generated password is for development use only. Your security configuration must be updated before running your application in production.
```
先后登录：http://localhost:8080/login
用户名是：arthas

登录成功之后，输入agent_id：mall-tiny-arthas。然后点击connect就连接成功了。

2. 本地测试请将arthas.tunnel-server地址改成localhost


