package com.hongx.hermestest2;

import xiaofei.library.hermes.annotation.ClassId;

/**
 * @author: fuchenming
 * @create: 2019-08-28 15:12
 */
@ClassId("UserStorage")
public interface IUserStorage {

    UserInfo getUserInfo();

    void setUserInfo(UserInfo userInfo);

}
