package com.anthony.trans.consumer.message.handler;

import com.anthony.trance.api.message.MoneyMessage;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import com.yiqiniu.easytrans.protocol.msg.ReliableMessageHandler;
import com.yiqiniu.easytrans.queue.consumer.EasyTransConsumeAction;
import org.springframework.stereotype.Component;

/**
 * @author BG343891
 * @date 2018/9/10
 */
@Component
public class MoneyMessageHandler implements ReliableMessageHandler<MoneyMessage> {

    @Override
    public EasyTransConsumeAction consume(EasyTransRequest<?, ?> easyTransRequest) {
        MoneyMessage message = (MoneyMessage) easyTransRequest;
        System.out.println("~~~~Producer~~~~~  message:" + message.toString());
//        throw new RuntimeException("``````````ERROR``````````````");
        return EasyTransConsumeAction.CommitMessage;
    }

    @Override
    public int getIdempotentType() {
        return 0;
    }
}
