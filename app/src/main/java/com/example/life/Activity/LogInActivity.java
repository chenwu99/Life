package com.example.life.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.life.R;
import com.example.life.classes.User;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText1,editText2;
    private Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        editText1=findViewById(R.id.editText1_Log);
        editText2=findViewById(R.id.editText2_Log);
        editText1.setOnClickListener(this);
        editText2.setOnClickListener(this);
        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LogInActivity.this, Zhuce.class);
                startActivity(intent);
            }
        });
    }

    private void login() {
        final User user = new User();
        //此处替换为你的用户名
        user.setUsername(editText1.getText().toString());
        //此处替换为你的密码
        user.setPassword(editText2.getText().toString());
        user.login(new SaveListener<User>() {
            @Override
            public void done(User bmobUser, BmobException e) {
                if (e == null) {
                    User user = BmobUser.getCurrentUser(User.class);
                    Toast.makeText(LogInActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LogInActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }



    @Override
    public void onClick(View v) {

    }
}
