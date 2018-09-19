# Springboot Activemq 和 RabbitMq

springboot 附加功能 防止重复提交表单

由于端口问题  两个只能启动一个 然后把另一个配置文件删掉或者修改启动端口


1.在本地启动 Activemq
访问 ：http://localhost:8161  账号密码 默认 admin

可以进入Activemq 管理界面

2.发送请求
	http://localhost/send   可以看到控制台的消费者接收到消息
	
3.Activemq 默认不支持发送其他 自定义类 
  需要 在自定义类上 加上序列化接口 Serializable
  并在application.properties 文件中加入  
	#相信所有类型 不然反序列化 失败
	
spring.activemq.packages.trust-all=true


4.RabbitMq安装教程 ：https://blog.csdn.net/hzw19920329/article/details/53156015
整合教程 ： https://www.jianshu.com/p/357391bc6fb4?utm_campaign=haruki&utm_content=note&utm_medium=reader_share&utm_source=qq