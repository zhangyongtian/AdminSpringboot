# AdminSpringboot

毕业设计后台springboot代码11月19日进行用户注册授权开发使用的是shiromybatis自动生成代码的注意点。

1. 引入依赖
```xml
<dependency>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-maven-plugin</artifactId>
	<version>1.4.0</version>
</dependency>
```

2. 加入插件
```xml
<plugin>
	<groupId>org.mybatis.generator</groupId>
	<artifactId>mybatis-generator-maven-plugin</artifactId>
	<version>1.3.7</version>
	<dependencies>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>5.1.35</version>
		</dependency>
	</dependencies>
</plugin>
```

3. 还有注意配置文件的生成位置
```properties
targetProject="./src/main/java"
```
