package com.anthony.easytrans.consumer.service;

import com.anthony.easytrans.consumer.dao.ConsumerDao;
import com.anthony.easytrans.consumer.pojo.ConsumerPO;
import com.anthony.trance.api.message.MoneyMessage;
import com.yiqiniu.easytrans.core.EasyTransFacade;
import com.yiqiniu.easytrans.protocol.msg.PublishResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.UUID;
import java.util.concurrent.Future;

/**
 * Created by BG343891 on 2018/9/6.
 */
@Service
public class ConsumerService {

    @Autowired
    private ConsumerDao consumerDao;

    @Autowired
    private EasyTransFacade transaction;

    public void dateInit() {
        ConsumerPO po = new ConsumerPO();
        po.setId(1);
        po.setMoney(1000);
        consumerDao.updateByPrimaryKey(po);
    }

    @Transactional("consumerTransactionManager")
    public String start() {

        Long trxId = System.currentTimeMillis();
        transaction.startEasyTrans(com.anthony.trance.api.common.Constant.MONEY_MESSAGE, trxId);
        MoneyMessage message = new MoneyMessage();
        message.setUuid(UUID.randomUUID().toString());
        message.setMoney(10000);
        Future<PublishResult> reliableMessage = transaction.execute(message);
        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter(){
            @Override
            public void beforeCommit(boolean readOnly) {
                System.out.println("~~beforeCommit~~");;
            }
        });

//        if (TransactionSynchronizationManager.hasResource(SyncConsumerServerHook.hook_key_easy_sync2Producer_trxId)) {
//            ((List<MoneyMessage>) TransactionSynchronizationManager.getResource(SyncConsumerServerHook.hook_key_SyncProducerServerHook)).add(message);
//        } else {
//            // 事物的唯一id，对应唯一一次：transaction.startEasyTrans
//            TransactionSynchronizationManager.bindResource(SyncConsumerServerHook.hook_key_easy_sync2Producer_trxId, System.currentTimeMillis());
//            TransactionSynchronizationManager.bindResource(SyncConsumerServerHook.hook_key_SyncProducerServerHook, Lists.newArrayList(message));
//
//            // Register a new transaction synchronization for the current thread.
//            TransactionSynchronizationManager.registerSynchronization(new SyncConsumerServerHook());
//        }
//        return "123";
//    }

//    private class SyncConsumerServerHook extends DjTransactionSynchronizationAdapter {
//        // define threadlocal constant key
//        private static final String hook_key_SyncProducerServerHook = "hook_key_SyncProducerServerHook";
//        // 事物的唯一id，对应唯一一次：transaction.startEasyTrans
//        private static final String hook_key_easy_sync2Producer_trxId = "hook_key_easy_sync2Producer_trxId";
//
//        @Override
//        public int getOrder() {
//            return 0;
//        }
//
//        @Override
//        public void beforeCommit(boolean readOnly) {
//            if (TransactionSynchronizationManager.hasResource(hook_key_easy_sync2Producer_trxId)) {
//                Long trxId = (Long) TransactionSynchronizationManager.getResource(hook_key_easy_sync2Producer_trxId);
//                List<MoneyMessage> messageList = (List<MoneyMessage>) TransactionSynchronizationManager.getResource(hook_key_SyncProducerServerHook);
//                if (!CollectionUtils.isEmpty(messageList)) {
//                    transaction.startEasyTrans(com.anthony.trance.api.common.Constant.MONEY_MESSAGE, trxId);
//                    for (MoneyMessage message : messageList) {
//                        System.out.println("~~~beforeCommit~~~" + message.getUuid());
//                        transaction.execute(message);
//                    }
//                }
//
//            }
//        }
//
//        @Override
//        public void afterCompletion(int status) {
//            System.out.println("~~~Completion~~~");
//            super.clearThreadLocal(hook_key_SyncProducerServerHook, hook_key_easy_sync2Producer_trxId);
//        }
        return "abc";
    }
}
