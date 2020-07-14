package com.example.registerandlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private EditText etUserId,etPasswd;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserId=findViewById(R.id.et_login_userid);
        etPasswd=findViewById(R.id.et_login_passwd);
        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userId=etUserId.getText().toString().trim();
                String passwd=etPasswd.getText().toString().trim();
                Intent intent=new Intent();
                if(userId.equals("xiaoming")&&passwd.equals("12345")){
                    //账号密码校验通过将数据据返回给MainActivity
                    intent.putExtra("userId",userId);
                    intent.putExtra("userName","张晓明");
                    //21为返回给MainActivity的结果码
                    setResult(21,intent);
                }else{
                    //校验不通过，将20结果码返回给MainActivity
                    setResult(20,intent);
                }
                //关闭当前窗口
                finish();
            }
        });
    }
}
