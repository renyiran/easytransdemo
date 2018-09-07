package com.anthony.easytrans.consumer.controller;

import com.anthony.easytrans.consumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by BG343891 on 2018/9/6.
 */
@Controller
public class StartAction {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/init")
    public String init(){
        consumerService.dateInit();
        return "OK";
    }


    @RequestMapping("/start")
    public String start(){
        consumerService.dateInit();
        return consumerService.start();
    }
}
