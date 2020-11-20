package com.zhang.biyeseji.remeberme;

import com.zhang.biyeseji.remeberme.util.VerificationUtil;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

//@SpringBootTest
//@RunWith(SpringRunner.class)
class RemebermeApplicationTests {
//mybatis自动生成代码的关键代码
//	@Test
//	void contextLoads() throws InvalidConfigurationException, IOException, XMLParserException, SQLException, InterruptedException {
//		List<String> warnings = new ArrayList<String>();
//		boolean overwrite = true;
//		// 指定配置文件
//		File configFile = new File(String.valueOf(Thread.currentThread().getContextClassLoader().getResource("generatorConfig.xml")).substring(5));
//		ConfigurationParser cp = new ConfigurationParser(warnings);
//		Configuration config = cp.parseConfiguration(configFile);
//		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//		MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//		myBatisGenerator.generate(null);
//
//	}
	@Test
	public void myTest(){
		VerificationUtil verificationUtil=VerificationUtil.getInstance();
		String result=verificationUtil.getRandRomVerification();
		System.out.println(result);
	}
}
