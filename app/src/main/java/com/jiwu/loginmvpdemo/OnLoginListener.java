package com.jiwu.loginmvpdemo;


public interface OnLoginListener {

   void loginSuccess(User user);

   void loginFailed();

}