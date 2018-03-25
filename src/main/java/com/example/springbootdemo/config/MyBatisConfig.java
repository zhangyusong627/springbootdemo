package com.example.springbootdemo.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

@Configuration
@MapperScan(basePackages = "com.example.springbootdemo.mapper")
public class MyBatisConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() throws Exception{
		Properties props = new Properties();
		props.put("driverClassName", env.getProperty("microservicedb1.jdbc.driverClassName"));
		props.put("url", env.getProperty("microservicedb1.jdbc.url"));
		props.put("username", env.getProperty("microservicedb1.jdbc.username"));
		props.put("password", env.getProperty("microservicedb1.jdbc.password"));
		return DruidDataSourceFactory.createDataSource(props);
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
		SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
		fb.setDataSource(ds);//:指定数据源
		fb.setTypeAliasesPackage("com.example.springbootdemo.model");//:指定基包
		fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapping/*.xml"));//:指定xml文件的位置
		return fb.getObject();
		
	}

}
