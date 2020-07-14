package com.example.registerandlogin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin, btnRegister;
    private ImageView ivLogin;
    private TextView tvUsername, tvUserId;
    //定义打开注册窗口的请求码
    private static final int REQUEST_REGISTER_CODE = 1;
    //定义打开登录窗口的请求码
    private static final int REQUEST_LOGIN_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        tvUserId = findViewById(R.id.tv_main_userid);
        tvUsername = findViewById(R.id.tv_main_username);
        ivLogin = findViewById(R.id.iv_login);
        btnLogin = findViewById(R.id.btn_main_login);
        btnRegister = findViewById(R.id.btn_main_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.btn_main_login:
                //打开登录窗口
                intent.setClass(this, LoginActivity.class);
                startActivityForResult(intent, REQUEST_LOGIN_CODE);
                break;
            case R.id.btn_main_register:
                //打开注册窗口
                intent.setClass(this, RegisterActivity.class);
                startActivityForResult(intent, REQUEST_REGISTER_CODE);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (intent == null) {
            return;
        }
        //根据requestCode判断是哪个窗口返回的数据
        switch (requestCode) {
            case REQUEST_REGISTER_CODE:
                //根据注册窗口返回的resultCode判断注册操作是否成功
                if (resultCode == 11) {
                    tvUserId.setText(intent.getStringExtra("userId"));
                    tvUsername.setText(intent.getStringExtra("userName"));
                    ivLogin.setImageResource(R.drawable.user_2);
                    Toast.makeText(this, "注册成功！", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(this, "注册失败！", Toast.LENGTH_LONG).show();
                }
                break;
            case REQUEST_LOGIN_CODE:
                //根据登录窗口返回的resultCode判断注册操作是否成功
                if (resultCode == 21) {
                    tvUserId.setText(intent.getStringExtra("userId"));
                    tvUsername.setText(intent.getStringExtra("userName"));
                    ivLogin.setImageResource(R.drawable.user_2);
                    Toast.makeText(this, "登陆成功！", Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(this, "登陆失败！", Toast.LENGTH_LONG).show();
                }
                break;
            default:
                Toast.makeText(this, "操作失败！", Toast.LENGTH_LONG).show();
                break;
        }
    }
}
