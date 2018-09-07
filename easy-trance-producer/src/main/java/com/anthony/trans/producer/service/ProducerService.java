package com.anthony.trans.producer.service;

import com.anthony.trans.producer.dao.ProducerDao;
import com.anthony.trans.producer.pojo.ProducerPO;
import com.yiqiniu.easytrans.core.EasyTransFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by BG343891 on 2018/9/7.
 */
@Service
public class ProducerService {

    @Autowired
    private ProducerDao producerDao;

    @Resource
    private EasyTransFacade transaction;


    public void dateInit(){
        ProducerPO po = new ProducerPO();
        po.setId(1);
        po.setMoney(1000);
        producerDao.updateByPrimaryKey(po);
    }

//    @Transactional
    public String start(){
        return "123";
    }
}
