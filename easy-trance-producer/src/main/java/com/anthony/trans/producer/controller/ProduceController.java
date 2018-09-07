package com.anthony.trans.producer.controller;

import com.anthony.trans.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by BG343891 on 2018/9/4.
 */
@RestController
public class ProduceController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping("/test")
    public String test() {
        return "BIBI";
    }


}
