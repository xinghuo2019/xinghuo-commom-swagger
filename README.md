spring boot 集成 swagger 封装公共组件

1、基于spring boot 2.0.7.RELEASE 版本，spring cloud Finchley.SR2版本

2、在Java spring boot项目pom.xml中引入星火swagger插件，如下
</br>
<p> 
<dependency>
	<groupId>com.xinghuo</groupId>
	<artifactId>xinghuo-commom-swagger</artifactId>
	<version>1.0.2</version>
</dependency>
</p> 
</br>
3、配置application.properties 属性文件</br>
	在application.properties 文件中加入如下配置</br>
	
	#swagger组件扫描的controller 路径，这里改成自己项目的controller路径</br>	
	xh.swagger.basePackage=com.xinghuo.controller</br>	
	#文档标题</br>	
	xh.swagger.title=测试swagger文档组件</br>	
	#服务文档描述说明</br>	
	xh.swagger.description=该服务是测试服务</br>	
	#开发者邮箱</br>	
	xh.swagger.emali=123453255@126.com</br>	
	#开发者</br>	
	xh.swagger.developerName=胡佛传</br>	
	#版本号</br>
	xh.swagger.version=1.0.0</br>
	这样就配置好swagger 组件了，在自己的业务controller方法中使用swagger注解就可以。</br>


