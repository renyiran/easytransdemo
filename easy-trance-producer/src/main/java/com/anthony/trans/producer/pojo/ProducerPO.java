package com.anthony.trans.producer.pojo;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author BG343891
 * @date 2018/9/4
 */
@Data
@Table(name = "producer")
public class ProducerPO {

    @Id
    private Integer id;
    private Integer money;
}
