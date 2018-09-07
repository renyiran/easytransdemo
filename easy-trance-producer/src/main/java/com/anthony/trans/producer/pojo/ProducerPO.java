package com.anthony.trans.producer.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by BG343891 on 2018/9/4.
 */
@Data
@Table(name = "producer")
public class ProducerPO {

    @Id
    private Integer id;
    private Integer money;
}
