package com.snow.postgresql.module;



import com.alibaba.fastjson.JSONObject;

import com.snow.postgresql.common.pojo.UserPo;
import com.snow.postgresql.common.repository.UserPoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 */
@Service
public class HomeService  {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserPoRepository userPoRepository;

    public JSONObject getUserList() {
        JSONObject json = new JSONObject();
        List<UserPo> userPoList = userPoRepository.find();
        json.put("userPoList", userPoList);
         System.out.println(userPoRepository.findByName("1").size());
        return json;
    }

    public JSONObject getUserList1() {
        JSONObject json = new JSONObject();
        List<UserPo> userPoList = userPoRepository.findAll();
        json.put("userPoList", userPoList);

        return json;
    }

    public List<UserPo> find() {
        List<UserPo> list = null;
        try {
            list = userPoRepository.find();
        } catch (Exception e) {
        }
        return list;
    }

    public String deleteUserById(Integer id){
        int  a = userPoRepository.deleteUserById(id);
        return "chenggong";
    }

    public String queryUserById(Integer id ,String name){
        int a = userPoRepository.queryUserById(id,name);
        return "成功";
    }

    public String countUserBy(Integer id ,String name ,String password){
        int a = userPoRepository.countUserBy(id,name,password);
        return "成功";
    }
}
