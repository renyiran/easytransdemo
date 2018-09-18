package com.anthony.trans.consumer.service;

import com.anthony.trans.consumer.dao.ConsumerDao;
import com.anthony.trans.consumer.pojo.ConsumerPO;
import com.yiqiniu.easytrans.core.EasyTransFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by BG343891 on 2018/9/7.
 */
@Service
public class ConsumerService {

    @Autowired
    private ConsumerDao consumerDao;

    @Resource
    private EasyTransFacade transaction;

    public void dateInit(){
        ConsumerPO po = new ConsumerPO();
        po.setId(1);
        po.setMoney(1000);
        consumerDao.updateByPrimaryKey(po);
    }

    public String start(){
        return "123";
    }
}
