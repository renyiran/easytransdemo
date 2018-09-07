package com.anthony.easytrans.consumer.message;

import com.anthony.easytrans.consumer.common.Constant;
import com.yiqiniu.easytrans.protocol.BusinessIdentifer;
import com.yiqiniu.easytrans.protocol.msg.ReliableMessagePublishRequest;
import lombok.Data;

/**
 * Created by BG343891 on 2018/9/6.
 */
@Data
@BusinessIdentifer(appId = Constant.APPID, busCode = MoneyMessege.BUSINESS_CODE)
public class MoneyMessege implements ReliableMessagePublishRequest {

    private static final long serialVersionUID = 1L;

    public static final String BUSINESS_CODE = "MoneyMessege";

    private Integer money;

}
