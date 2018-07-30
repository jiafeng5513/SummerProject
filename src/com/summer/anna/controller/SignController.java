package com.summer.anna.controller;

import com.summer.anna.DAO.UserDAO;
import com.summer.anna.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;
import java.util.Map;

//from Maven
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;


@Controller
/*
截取POST
 */
@RequestMapping("/html")
public class SignController {
    @RequestMapping(value = "LoginAction", method = RequestMethod.POST)
    @ResponseBody
    public String CheckSignIn(@RequestBody String param){
        JSONObject jo=new JSONObject();

        //如果页面传的是json字符串，用下列方式解析
		Map<String, Object> m=(Map<String, Object> )jo.parse(param); //string转map
		JSONObject parseObject = jo.parseObject(param); //string转json
		System.out.println("接收到的json obj "+parseObject);

        String email=(String)parseObject.get("emailAdd");
        String passwd=(String)parseObject.get("password");
        System.out.println("解析出来的email:"+email+"  解析出来的psw:"+passwd);
        UserDAO _userDAO=new UserDAO();
        if (_userDAO.SignIn(email,passwd)){
            return "succeed";
        }else{
            return "failure";
        }

//        //如果页面传的是json数组字符串，用下列方式解析
//        List<Map> parseArray = jo.parseArray(param, Map.class);
//        System.out.println(parseArray); //string转list
//
//        JSONArray parseArray2 = jo.parseArray(param);
//        System.out.println(parseArray2);

    }

}
