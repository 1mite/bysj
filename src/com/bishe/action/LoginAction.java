package com.bishe.action;

import com.bishe.entity.Student;
import com.bishe.service.StudentServiceImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.List;
import java.util.Map;

/**
 * Created by mite on 2015/5/12.
 */
public class LoginAction  extends ActionSupport implements Action ,SessionAware {
    private String username;
    private String password;
    private String usertype;
    private StudentServiceImpl studentServiceImpl;
    private Map<String, Object> session;

    public String getUsertype() {
        return usertype;
    }

    public StudentServiceImpl getStudentServiceImpl() {
        return studentServiceImpl;
    }

    public void setStudentServiceImpl(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }


    public String register(){
        //ѧ��ע��
        if (usertype != null && usertype.equals("student"));{
            String st = studentServiceImpl.register(username, password);
            if(st.equals("SUCCESS")){
                return SUCCESS;
            }
            else if(st.equals("ERRO")){
                return ERROR;
            }
            return INPUT;
        }
    }
    public String login(){
        //ѧ����¼
        if(usertype != null && usertype.equals("student")){
            List<Student> st = studentServiceImpl.login(username, password);
            if(st != null && st.size() == 1){
                session.put("username", st.get(0).getStuname());
                return SUCCESS;
            }
            else{
                return ERROR;
            }

        }
        return INPUT;
    }



}
