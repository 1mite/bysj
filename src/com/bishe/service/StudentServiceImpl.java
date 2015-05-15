package com.bishe.service;

import com.bishe.dao.StudentDao;
import com.bishe.entity.Student;
import com.bishe.service.impl.LoginService;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mite on 2015/5/12.
 */

public class StudentServiceImpl{
    private StudentDao studentDao;

    public StudentDao getStudentDao() {
        return studentDao;
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public String register(String username, String password) {
        List<Student> ls = findStudentbyUsername(username);
        if (ls == null ||ls.size() == 0){
            Student stu = new Student();
            stu.setStuname(username);
            stu.setStupassword(password);
            boolean flag = studentDao.save(stu);
            if(flag = true)
                return "SUCCESS";
            else{
                return "ERRO";
            }
        }
        return "EXITS";
    }


    public  List<Student>findStudentbyUsername(String username){
        System.out.println(username);
            String hql = "FROM Student student WHERE student.stuname=:username ";
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("username", username);
        List<Student> list = studentDao.query(hql, paramsMap);
        //再加一个限制条件 查表看是否通过注册字段为1
        return list;
    }

    public List<Student> login(String username, String password) {
        List<Student> ls = findStudentbyUsernamePassword(username, password);
            return ls;
    }

    private List<Student> findStudentbyUsernamePassword(String username, String password) {
        System.out.println(username);
        String hql = "FROM Student student WHERE student.stuname=:username and student.stupassword=:password";
        Map<String, Object> paramsMap = new HashMap<String, Object>();
        paramsMap.put("username", username);
        paramsMap.put("password", password);
        List<Student> list = studentDao.query(hql, paramsMap);
        //再加一个限制条件 查表看是否通过注册字段为1
        return list;
    }

}
