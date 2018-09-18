package com.anthony.trans.producer.controller;

import com.anthony.trans.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BG343891 on 2018/9/6.
 */
@RestController
public class StartAction {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/init")
    public String init() {
        producerService.dateInit();
        return "OK";
    }


    @RequestMapping("/start")
    public String start() {
        for (int i = 0; i < 10000; i++) {
            producerService.start(i);
        }
        return "OK";
//        return producerService.start();
    }
}
