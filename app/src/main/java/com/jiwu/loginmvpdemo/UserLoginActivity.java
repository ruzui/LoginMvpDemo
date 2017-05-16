package com.jiwu.loginmvpdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {
   private EditText et_username;
   private EditText et_password;
   private Button btn_login;
   private Button btn_clear;
   private ProgressDialog dialog;
   private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_user_login);

      et_username = (EditText) findViewById(R.id.et_username);
      et_password = (EditText) findViewById(R.id.et_password);
      btn_login = (Button) findViewById(R.id.btn_login);
      btn_clear = (Button) findViewById(R.id.btn_clear);
      dialog = new ProgressDialog(this);
      btn_login.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            mUserLoginPresenter.login();
         }
      });
      btn_clear.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
            mUserLoginPresenter.clear();
         }
      });

   }

   @Override
   public String getUserName() {
      return et_username.getText().toString();
   }

   @Override
   public String getPassword() {
      return et_password.getText().toString();
   }

   @Override
   public void showLoading() {

      dialog.show();
   }

   @Override
   public void hideLoading() {
      dialog.hide();
   }

   @Override
   public void toMainActivity(User user) {
      Toast.makeText(this, user.getUsername() +
              " 登录成功", Toast.LENGTH_SHORT).show();
      Intent intent  = new Intent(this,MainActivity.class);
      startActivity(intent);
   }

   @Override
   public void showFailedError() {
      Toast.makeText(this,
              "登录失败", Toast.LENGTH_SHORT).show();
   }

   @Override
   public void clearUserName() {
      et_username.setText("");
   }

   @Override
   public void clearPassword() {
      et_password.setText("");
   }

}