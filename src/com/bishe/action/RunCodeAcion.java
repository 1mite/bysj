package com.bishe.action;

import com.bishe.service.RunJavaImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by mite on 2015/5/11.
 */
public class RunCodeAcion extends ActionSupport {
    private String code;
    private String codeType;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeType() {
        return codeType;
    }

    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
    public String execute()throws Exception{
        String result = "";
        if(codeType.equals("java")){
            result = new RunJavaImpl().runCode(code);
        }
        HttpServletResponse httpServletResponse =  ServletActionContext.getResponse();
        httpServletResponse.setContentType("text/html;charset=utf-8");
        httpServletResponse.getWriter().print(result);
        return null;
    }
}
