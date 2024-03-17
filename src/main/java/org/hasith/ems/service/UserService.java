package org.hasith.ems.service;

import org.hasith.ems.entity.User;
import org.hasith.ems.util.HibernateUtil;
import org.hibernate.Session;

public class UserService {
    public User searchUser(String username,String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("select u from User u where u.username =:username and u.password =: password",User.class)
                .setParameter("username"  , username)
                .setParameter("password", password).uniqueResult();
    }
}
