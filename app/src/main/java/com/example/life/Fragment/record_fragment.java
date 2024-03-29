package com.example.life.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.R;
import com.example.life.classes.User;

import cn.bmob.v3.BmobUser;

public class record_fragment extends Fragment {

    private TextView t1,t2,t3,t4,t5;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_record_fragment, container, false);
        t1=view.findViewById(R.id.textView3);
        t2=view.findViewById(R.id.textView5);
        t3=view.findViewById(R.id.textView6);
        t4=view.findViewById(R.id.textView7);
        t5=view.findViewById(R.id.textView8);
//        t1.setText(record.getWeight());
//        t2.setText(record.getMood());
//        t3.setText(record.getHabit());
//        t4.setText(record.getMajiaxian());
//        t5.setText(record.getRemember());
        if (BmobUser.isLogin()) {
            User user = BmobUser.getCurrentUser(User.class);
            String weight = user.getWeight();
            t1.setText(weight);
            String mood = user.getMood();
            t2.setText(mood);
            String habit = user.getHabit();
            t3.setText(habit);
            String majiaxian = user.getMajiaxian();
            t4.setText(majiaxian);
            String remember = user.getRemember();
            t5.setText(remember);
            Toast.makeText(getActivity(), weight + mood +habit + majiaxian, Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getActivity(), "登录失效，请重新登陆", Toast.LENGTH_SHORT).show();
        }
        return view;
    }








    }
