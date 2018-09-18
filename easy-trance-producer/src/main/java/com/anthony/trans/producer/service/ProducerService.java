package com.anthony.trans.producer.service;

import com.anthony.trans.producer.dao.ProducerDao;
import com.anthony.trance.api.message.MoneyMessage;
import com.anthony.trans.producer.pojo.ProducerPO;
import com.yiqiniu.easytrans.core.ConsistentGuardian;
import com.yiqiniu.easytrans.core.EasyTransFacade;
import com.yiqiniu.easytrans.log.TransactionLogReader;
import com.yiqiniu.easytrans.log.vo.LogCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by BG343891 on 2018/9/6.
 */
@Service
public class ProducerService {

    @Autowired
    private ProducerDao producerDao;
    @Resource
    private TransactionLogReader logReader;
    @Resource
    private ConsistentGuardian guardian;


    @Autowired
    private EasyTransFacade transaction;

    public void dateInit() {
        ProducerPO po = new ProducerPO();
        po.setId(1);
        po.setMoney(1000);
        producerDao.updateByPrimaryKey(po);
    }

    @Transactional
    public String start(int i) {

        Long trxId = System.currentTimeMillis();
        transaction.startEasyTrans(com.anthony.trance.api.common.Constant.MONEY_MESSAGE, trxId + Long.valueOf(i));
        MoneyMessage message = new MoneyMessage();
        message.setUuid(UUID.randomUUID().toString());
        message.setMoney(10000);
        transaction.execute(message);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void beforeCommit(boolean readOnly) {
                System.out.println("~~beforeCommit~~");
                ;
            }

            @Override
            public void afterCompletion(int status) {
                System.out.println("~~afterCompletion~~");
            }
        });

        // 执行一遍后台补偿任务，以避免上述操作有未补偿成功的
        // execute consistent guardian in case of timeout
        List<LogCollection> unfinishedLogs = logReader.getUnfinishedLogs(null, 100, new Date());
        for (LogCollection logCollection : unfinishedLogs) {
            guardian.process(logCollection);
        }
        return "abc";
    }
}
