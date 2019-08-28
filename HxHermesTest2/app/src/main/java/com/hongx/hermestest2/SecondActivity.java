package com.hongx.hermestest2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import xiaofei.library.hermes.Hermes;
import xiaofei.library.hermes.HermesListener;
import xiaofei.library.hermes.HermesService;

/**
 * @author: fuchenming
 * @create: 2019-08-28 13:27
 */
public class SecondActivity extends Activity {

    private IUserStorage mUserStorage;
    private UserInfo mUserInfo;

    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        etName = findViewById(R.id.etName);

        Hermes.setHermesListener(new HermesListener() {
            @Override
            public void onHermesConnected(Class<? extends HermesService> service) {

                //连接成功，首先获取单例
                mUserStorage = Hermes.getInstance(IUserStorage.class);
                //通过单例获取UserInfo
                mUserInfo = mUserStorage.getUserInfo();

                etName.setText(mUserInfo.getmName());

            }
        });

        Hermes.connect(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //断开Hermes服务
        Hermes.disconnect(this);
    }

    public void save(View view) {

        mUserInfo.setmName(etName.getText().toString());

        mUserStorage.setUserInfo(mUserInfo);

        finish();
    }
}
