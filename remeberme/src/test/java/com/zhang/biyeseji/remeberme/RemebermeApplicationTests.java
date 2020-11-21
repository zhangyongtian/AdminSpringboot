package com.zhang.biyeseji.remeberme;

import com.zhang.biyeseji.remeberme.util.VerificationUtil;
import com.zhang.biyeseji.remeberme.util.mail.IMailService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

@SpringBootTest
@RunWith(SpringRunner.class)
class RemebermeApplicationTests {
	@Autowired
	private IMailService iMailService;
//	@Autowired
//	JavaMailSenderImpl javaMailSender;
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
//		iMailService.sendHtmlMail("zhangyongtianaa@sina.com","html邮件测试","898989");
//		iMailService.sendSimpleMail("zhangyongtianaa@sina.com","html邮件测试","898989");
//		iMailService.sendAttachmentsMail("zhangyongtianaa@sina.com","html邮件测试","<h1>内容：第一封html邮件</h1>","D:\\centos\\1.jpg");
	}
}
