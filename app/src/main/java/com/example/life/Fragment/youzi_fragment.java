package com.example.life.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.example.life.Activity.MainActivity;
import com.example.life.R;
import com.example.life.classes.User;

import cn.bmob.v3.BmobUser;

import static android.view.KeyEvent.KEYCODE_BACK;

public class youzi_fragment extends Fragment {
//
//    private TextView t1,t2,t3,t4,t5;
//    private cn.bmob.v3.BmobUser BmobUser;
    private WebView webView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view=inflater.inflate(R.layout.fragment_youzi_fragment, container, false);
        WebView webview = view.findViewById(R.id.web);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebChromeClient(new WebChromeClient());
        webview.loadUrl("https://www.gotokeep.com/explore");
        // 为图片添加放大缩小功能
        webview.getSettings().setUseWideViewPort(true);
        webview.getSettings().setBlockNetworkImage(false);
        //设置缓存模式
        webview.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        //webview7.0以上需加以下代码
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) webview.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
//        // 开启DOM storage API 功能
//        webDianpu.getSettings().setDomStorageEnabled(true);
//        // 开启database storage API功能
//        webDianpu.getSettings().setDatabaseEnabled(true);
//        String cacheDirPath = getFilesDir().getAbsolutePath() + APP_CACHE_DIRNAME;
//        Log.i("cachePath", cacheDirPath);
//        // 设置数据库缓存路径
//        webDianpu.getSettings().setAppCachePath(cacheDirPath);
//        webDianpu.getSettings().setAppCacheEnabled(true);
//        webDianpu.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
//        deleteDatabase("WebView.db");
        webview.clearHistory();
        webview.clearFormData();
//        getCacheDir().delete();
        webview.clearCache(true);
        //webView.setWebViewClient(new WebViewClient());
//        webView = view.findViewById(R.id.web);
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
//                return super.shouldOverrideUrlLoading(view, request);
//            }
       // });
        //webView.loadUrl("https://www.gotokeep.com/explore");
//       // User record= ((MainActivity)getActivity()).record;
//        t1=view.findViewById(R.id.textView3);
//        t2=view.findViewById(R.id.textView5);
//        t3=view.findViewById(R.id.textView6);
//        t4=view.findViewById(R.id.textView7);
//        t5=view.findViewById(R.id.textView8);
////        t1.setText(record.getWeight());
////        t2.setText(record.getMood());
////        t3.setText(record.getHabit());
////        t4.setText(record.getMajiaxian());
////        t5.setText(record.getRemember());
//        if (BmobUser.isLogin()) {
//            User user = BmobUser.getCurrentUser(User.class);
//            String weight = user.getWeight();
//            t1.setText(weight);
//            String mood = user.getMood();
//            t2.setText(mood);
//            String habit = user.getHabit();
//            t3.setText(habit);
//            String majiaxian = user.getMajiaxian();
//            t4.setText(majiaxian);
//            String remember = user.getRemember();
//            t5.setText(remember);
//            Toast.makeText(getActivity(), weight + mood +habit + majiaxian, Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(getActivity(), "登录失效，请重新登陆", Toast.LENGTH_SHORT).show();
//        }

        return view;
        //return inflater.inflate(R.layout.fragment_youzi_fragment, container, false);
    }






}
