package com.hongx.hermestest2;

import xiaofei.library.hermes.annotation.ClassId;

/**
 * @author: fuchenming
 * @create: 2019-08-28 15:15
 */
@ClassId("UserStorage")
public class UserStorage implements IUserStorage {

    UserInfo userInfo;
    private static UserStorage sInstance = null;

    public static synchronized UserStorage getInstance() {
        if (sInstance == null) {
            sInstance = new UserStorage();
        }
        return sInstance;
    }

    @Override
    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;

    }
}
