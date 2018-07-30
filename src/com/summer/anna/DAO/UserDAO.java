package com.summer.anna.DAO;
/*
封装与"用户"相关的数据库访问操作
 */
public class UserDAO {

    //检查用户名和密码是否对应
    public boolean SignIn(String email,String passwd){
        if (passwd.equals("12345678")){
            return true;
        }else{
            return false;
        }
    }
}
