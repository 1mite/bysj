package com.bishe.service.impl;


/**
 * Created by mite on 2015/5/12.
 */
public interface LoginService {
    public String login(String username, String password);
    public String register(String username, String password);
    public String logout();
}
