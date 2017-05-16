package com.jiwu.loginmvpdemo;


public interface IUserLoginView {

   String getUserName();

   String getPassword();

   void showLoading();

   void hideLoading();

   void toMainActivity(User user);

   void showFailedError();

   void clearUserName();

   void clearPassword();

}