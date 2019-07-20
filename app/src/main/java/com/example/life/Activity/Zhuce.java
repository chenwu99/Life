package com.example.life.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.life.R;
import com.example.life.classes.User;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class Zhuce extends AppCompatActivity implements View.OnClickListener {

    private EditText editText1,editText2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        editText1=findViewById(R.id.editText1_Zhuce);
        editText2=findViewById(R.id.editText2_Zhuce);
        editText1.setOnClickListener(this);
        editText2.setOnClickListener(this);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
                finish();
            }
        });

    }
    private void signUp() {
        final User user = new User();
        user.setID(editText1.getText().toString());
        user.setUsername(editText1.getText().toString());
        user.setPassword(editText2.getText().toString());
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User user, BmobException e) {
                if (e == null) {
                    Toast.makeText(Zhuce.this,"注册成功",Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Zhuce.this, "注册失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {

    }
}
