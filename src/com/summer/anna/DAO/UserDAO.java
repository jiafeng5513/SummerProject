package com.summer.anna.DAO;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.summer.anna.entity.UserEntity;
import org.hibernate.query.Query;

/*
封装与"用户"相关的数据库访问操作
 */
public class UserDAO {

    Configuration m_configuration = null;
    SessionFactory m_sessionFactory = null;

    //构造函数
    public UserDAO(){
        m_configuration = new Configuration();
        m_configuration.configure("com/summer/anna/entity/hibernate.cfg.xml");
        m_sessionFactory = m_configuration.buildSessionFactory();
    }
    //检查用户名和密码是否对应
    public boolean SignIn(String email,String passwd){

        Session session = m_sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Query query = session.createQuery("FROM UserEntity WHERE emailAdd= :email");
            query.setParameter("email", email);
            List<UserEntity> users =query.list();

//            System.out.println("查询结果数量 = "+users.size());
//            System.out.println("邮箱: "+users.get(0).getEmailAdd());
//            System.out.println("用户名: "+users.get(0).getUserName());
//            System.out.println("真实密码: "+users.get(0).getPassword());
//            System.out.println("收到密码: "+passwd);

            if (users.size()==1&&((users.get(0))).getPassword().equals(passwd)){
                //验证成功
                tx.commit();
                session.close();
                return true;
            }

        } catch (HibernateException var10) {
            if (tx != null) {
                tx.rollback();
            }
            var10.printStackTrace();
        } finally {
            session.close();
            //return false;
        }
        session.close();
        return false;
    }
}
