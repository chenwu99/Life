package com.example.life.Fragment;


import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.life.R;
import com.example.life.classes.User;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class tata_fragments<view> extends Fragment {
    private EditText editText1,editText2,editText3,editText4;
    private Button button,button1,button2,button3,button4;
    User user =new User();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_tata_fragments, container, false);
        button=view.findViewById(R.id.button11_tata);
        editText1=view.findViewById(R.id.edittext);
        editText2=view.findViewById(R.id.edittext2_tata);
        editText3=view.findViewById(R.id.editt3_tata);
        editText4=view.findViewById(R.id.edittext1_tata);
        button1=view.findViewById(R.id.button11_tata);
        button2=view.findViewById(R.id.button2_tata);
        button3=view.findViewById(R.id.button3_tata);
        button4=view.findViewById(R.id.button4_tata);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"超开心",Toast.LENGTH_SHORT).show();
                user.setMood("超开心哦");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"开心",Toast.LENGTH_SHORT).show();
                user.setMood("开心");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"一般",Toast.LENGTH_SHORT).show();
                user.setMood("一般啦");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"伤心啦",Toast.LENGTH_SHORT).show();
                user.setMood("伤心奥");
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUser();
            }
        });

                       // FragmentManager manager = getActivity().getSupportFragmentManager();
                        //FragmentTransaction transaction = manager.beginTransaction();
                        //transaction.replace(R.id.fragment,new youzi_fragment()).commit();
                       // ((MainActivity)getActivity()).record = user;
//                }
//            }
//        });
        return view;
    }

    /**
     * 更新用户操作并同步更新本地的用户信息
     */
    private void updateUser() {
        final User user = BmobUser.getCurrentUser(User.class);
        user.setHabit(editText2.getText().toString());
        user.setMood(user.getMood());
        user.setWeight(editText1.getText().toString());
        user.setMajiaxian(editText3.getText().toString());
        user.setRemember(editText4.getText().toString());
        user.update(new UpdateListener() {
            @Override
            public void done(BmobException e) {
                if (e == null) {
                    Toast.makeText(getActivity(), "更新成功：", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), "更新失败：", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}

