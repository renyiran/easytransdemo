package com.anthony.easytrans.consumer.service;

import com.anthony.easytrans.consumer.dao.ConsumerDao;
import com.anthony.easytrans.consumer.pojo.ConsumerPO;
import com.yiqiniu.easytrans.core.EasyTransFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by BG343891 on 2018/9/6.
 */
@Service
public class ConsumerService {

    @Autowired
    private ConsumerDao consumerDao;

    @Autowired
    private EasyTransFacade transaction;

    public void dateInit(){
        ConsumerPO po = new ConsumerPO();
        po.setId(1);
        po.setMoney(1000);
        consumerDao.updateByPrimaryKey(po);
    }

    @Transactional
    public String start(){
        return "123";
    }
}
