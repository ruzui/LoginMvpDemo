package com.jiwu.loginmvpdemo;


public interface IUserBiz {
   void login(String username, String password, OnLoginListener loginListener);

}