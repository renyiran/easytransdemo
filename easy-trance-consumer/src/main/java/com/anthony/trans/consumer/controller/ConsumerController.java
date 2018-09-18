package com.anthony.trans.consumer.controller;

import com.anthony.trans.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BG343891 on 2018/9/4.
 */
@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/test")
    public String test() {
        return "BIBI";
    }


}
