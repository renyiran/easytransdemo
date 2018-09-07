package com.anthony.trans.producer;

import com.anthony.trans.producer.mapper.CommonMapper;
import com.yiqiniu.easytrans.EnableEasyTransaction;
import com.yiqiniu.easytrans.queue.impl.kafka.EnableQueueKafkaImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "com.anthony.trans.producer.dao", markerInterface = CommonMapper.class)
@EnableEasyTransaction
@EnableQueueKafkaImpl
@EnableTransactionManagement
@EnableAutoConfiguration(exclude=DataSourceAutoConfiguration.class)
public class EasyTranceProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyTranceProducerApplication.class, args);
	}
}
