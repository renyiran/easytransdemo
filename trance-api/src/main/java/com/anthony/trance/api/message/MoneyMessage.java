package com.anthony.trance.api.message;

import com.anthony.trance.api.common.Constant;
import com.yiqiniu.easytrans.protocol.BusinessIdentifer;
import com.yiqiniu.easytrans.protocol.msg.ReliableMessagePublishRequest;
import lombok.Data;

/**
 * Created by BG343891 on 2018/9/6.
 */
@Data
@BusinessIdentifer(appId = Constant.APPID, busCode = Constant.MONEY_MESSAGE)
public class MoneyMessage implements ReliableMessagePublishRequest {

    private static final long serialVersionUID = 1L;

    private String uuid;
    private Integer money;

}
