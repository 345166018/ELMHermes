package com.hongx.hermestest2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import xiaofei.library.hermes.Hermes;

public class MainActivity extends AppCompatActivity {

    private UserStorage mUserStorage;
    private UserInfo mUserInfo;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Hermes注册被子进程共享的类
        Hermes.register(UserStorage.class);
        tvName = findViewById(R.id.tvName);
        //获取单例
        mUserStorage = UserStorage.getInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //以下操作放在onResume里，这样在子Activity返回这里的时候，信息会及时更新
        //获取UserInfo
        mUserInfo = mUserStorage.getUserInfo();
        if (mUserInfo == null) {
            mUserInfo = new UserInfo();
            mUserStorage.setUserInfo(mUserInfo);
        }
        tvName.setText(mUserInfo.getmName());

    }

    public void toSecond(View view) {
        startActivity(new Intent(MainActivity.this,SecondActivity.class));
    }
}
