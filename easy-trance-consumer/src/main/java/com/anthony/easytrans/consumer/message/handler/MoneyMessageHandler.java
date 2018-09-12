package com.anthony.easytrans.consumer.message.handler;

import com.anthony.trance.api.message.MoneyMessage;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import com.yiqiniu.easytrans.protocol.msg.ReliableMessageHandler;
import com.yiqiniu.easytrans.queue.consumer.EasyTransConsumeAction;

/**
 * @author BG343891
 * @date 2018/9/10
 */
public class MoneyMessageHandler implements ReliableMessageHandler<MoneyMessage> {

    @Override
    public EasyTransConsumeAction consume(EasyTransRequest<?, ?> easyTransRequest) {
        MoneyMessage message = (MoneyMessage) easyTransRequest;
        System.out.println("~~~~Consumer~~~~~  message:" + message.getMoney());
        return EasyTransConsumeAction.CommitMessage;
    }

    @Override
    public int getIdempotentType() {
        return 0;
    }
}
