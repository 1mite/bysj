package com.bishe.dao;

import com.bishe.entity.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by mite on 2015/5/12.
 */
public class StudentDao {
    private SessionFactory sessionFactory;

    public StudentDao() {
        // TODO Auto-generated constructor stub
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * @return
     */
    public List<Student> query(String sql, Map<String, Object> paramsMap) {
        // TODO Auto-generated method stub
        List<Student> list = null;
        try {
            Query query = getSession().createQuery(sql);
            Set<String> keys = paramsMap.keySet();
            for (String key : keys) {
                query = query.setParameter(key, paramsMap.get(key));
            }
            list = query.list();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return list;
    }
    public boolean save(Student stu) {
        // TODO Auto-generated method stub
        boolean flag = false;
        System.out.println(stu.toString());
        Serializable genId = getSession().save(stu);
        if (genId != null) {
            flag = true;
        }
        return flag;
    }
}
