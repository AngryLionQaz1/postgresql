package com.snow.postgresql.module;


import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Administrator
 */
@RestController
@RequestMapping(value = "home")
public class HomeController {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private HomeService service;

    @GetMapping(value = "getUserList")
    public JSONObject getUserList() {

        return service.getUserList();
    }

    @GetMapping(value = "getUserList1")
    public JSONObject getUserList1() {
        return service.getUserList1();
    }
}
