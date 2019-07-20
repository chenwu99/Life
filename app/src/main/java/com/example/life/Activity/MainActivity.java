package com.example.life.Activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.Fragment.record_fragment;
import com.example.life.Fragment.tata_fragments;
import com.example.life.Fragment.youzi_fragment;
import com.example.life.R;
import com.example.life.classes.User;

import cn.bmob.v3.BmobUser;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView textView;
    private DrawerLayout drawerLayout;
    public User record;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textview_t);
        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view1);
        drawerLayout =findViewById(R.id.drawer);
        ActionBar actionBar=getSupportActionBar();
        //if(actionBar!=null){
        ////    //actionBar.setDisplayHomeAsUpEnabled(true);
          //  actionBar.setHomeAsUpIndicator(R.drawable.id);
        //}
        BottomNavigationView navView = findViewById(R.id.nav_view);
        replaceFragment(new record_fragment());//显示记录的界面
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_tast:
                        Intent intent = new Intent(MainActivity.this, LogInActivity.class);
                        startActivity(intent);
                        break;
                        case R.id.nav_mail:
                            finish();

                }
                //drawerLayout.closeDrawers();
                return true;
            }
        });

        if (BmobUser.isLogin()) {
            User user = BmobUser.getCurrentUser(User.class);

            Toast.makeText(MainActivity.this, "已经登录：" , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "尚未登录" , Toast.LENGTH_SHORT).show();
        }
    }



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.youzi:
                    textView.setText("小柚子");
                    replaceFragment(new youzi_fragment());
                    return true;
                case R.id.tata:
                    textView.setText("记录");
                    replaceFragment(new tata_fragments());
                    return true;
                case R.id.record:
                    textView.setText("她她圈");
                    replaceFragment(new record_fragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;
            default:
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }

    private  void replaceFragment(Fragment fragment){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fragment,fragment).commit();
    }

}
