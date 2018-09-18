package com.anthony.trans.producer;

import com.anthony.trans.producer.mapper.CommonMapper;
import com.anthony.trance.api.config.EnableEasyTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author BG343891
 */
@SpringBootApplication
@EnableEasyTransaction
@ComponentScan(basePackages = "com.anthony")
@EnableTransactionManagement
@MapperScan(basePackages = "com.anthony.trans.producer.dao", markerInterface = CommonMapper.class)
public class EasyTranceProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EasyTranceProducerApplication.class, args);
    }

//    /**
//     * 本BEAN用于配置appid+busCode的映射关系，如果不提供该bean则使用默认实现IdenticalQueueTopicMapper
//     *
//     * @return
//     */
//    @Bean
//    public QueueTopicMapper mapper() {
//        return new QueueTopicMapper() {
//
//            @Override
//            public String[] mapToTopicTag(String appid, String busCode) {
//                return new String[]{"TestPrefix" + appid, busCode};
//            }
//
//            @Override
//            public String[] mapToAppIdBusCode(String topic, String tag) {
//                return new String[]{topic.replace("TestPrefix", ""), tag};
//            }
//        };
//    }

//    @Component
//    @ConfigurationProperties(prefix = "easytrans.log.database.druid")
//    public static class EasyTransTestProperties {
//        private String url;
//        private String username;
//        private String password;
//        private String driverClassName;
//
//        public String getUrl() {
//            return url;
//        }
//
//        public void setUrl(String url) {
//            this.url = url;
//        }
//
//        public String getUsername() {
//            return username;
//        }
//
//        public void setUsername(String username) {
//            this.username = username;
//        }
//
//        public String getPassword() {
//            return password;
//        }
//
//        public void setPassword(String password) {
//            this.password = password;
//        }
//
//        public String getDriverClassName() {
//            return driverClassName;
//        }
//
//        public void setDriverClassName(String driverClassName) {
//            this.driverClassName = driverClassName;
//        }
//    }

//    private DataSource createDatasource(EasyTransTestProperties properties) {
//        DruidDataSource ds = new DruidDataSource();
//        ds.setUrl(properties.getUrl());
//        ds.setUsername(properties.getUsername());
//        ds.setPassword(properties.getPassword());
//        ds.setDriverClassName(properties.getDriverClassName());
//        ds.setMaxActive(10);
//        ds.setInitialSize(1);
//        ds.setMinIdle(1);
//        ds.setPoolPreparedStatements(true);
//        return ds;
//    }


    //--------
//    @Bean
//    public DataSource whole(EasyTransTestProperties properties){
//        return createDatasource(properties);
//    }

//    @Bean
//    public JdbcTemplate wholeJdbcTemplate(DataSource primaryDataSource){
//        return new JdbcTemplate(primaryDataSource);
//    }
//
//    @Bean
//    @Primary
//    public DataSourceTransactionManager wholeTransactionManager(DataSource primaryDataSource){
//        return new DataSourceTransactionManager(primaryDataSource);
//    }

    //--------
//    @Bean
//    public DataSource consumer(EasyTransTestProperties properties){
//        return createDatasource(properties);
//    }
//    @Bean
//    public JdbcTemplate consumerJdbcTemplate(DataSource primaryDataSource){
//        return new JdbcTemplate(primaryDataSource);
//    }
//    @Bean
//    public DataSourceTransactionManager consumerTransactionManager(DataSource dataSource){
//        return new DataSourceTransactionManager(dataSource);
//    }


    //--------

}
