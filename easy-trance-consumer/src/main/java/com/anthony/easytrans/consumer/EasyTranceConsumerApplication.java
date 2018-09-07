package com.anthony.easytrans.consumer;

import com.anthony.easytrans.consumer.mapper.CommonMapper;
import com.yiqiniu.easytrans.EnableEasyTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author BG343891
 */
@SpringBootApplication
@MapperScan(basePackages = "com.anthony.easytrans.consumer.dao", markerInterface = CommonMapper.class)
@EnableEasyTransaction
@EnableTransactionManagement
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class EasyTranceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyTranceConsumerApplication.class, args);
	}
}
