package com.anthony.trans.consumer;

import com.anthony.trance.api.config.EnableEasyTransaction;
import com.anthony.trans.consumer.mapper.CommonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author BG343891
 */
@SpringBootApplication
@MapperScan(basePackages = "com.anthony.trans.consumer.dao", markerInterface = CommonMapper.class)
@EnableEasyTransaction
@ComponentScan(basePackages = "com.anthony")
@EnableTransactionManagement
public class EasyTranceConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyTranceConsumerApplication.class, args);
	}
}
