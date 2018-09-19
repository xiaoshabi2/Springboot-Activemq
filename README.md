# Springboot Activemq

springboot 附加功能 防止重复提交表单

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