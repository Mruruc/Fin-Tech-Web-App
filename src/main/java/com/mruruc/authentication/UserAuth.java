package com.mruruc.authentication;

import com.mruruc.exceptions.UserAuthExceptions;
import com.mruruc.model.login.UserLogin;

public class UserAuth {
    public UserAuth(){}

    public boolean authNewUser(UserLogin userLogin) throws UserAuthExceptions{
        if(userLogin.getUserName() == null || userLogin.getPassword() == null){
            throw new NullPointerException("Filed/s Null!");
        }
        AuthUtils.checkForBlankAndEmptyAndNull(userLogin.getUserName(), UserAuthExceptions.class,"User Name Required!");
        AuthUtils.checkForBlankAndEmptyAndNull(userLogin.getPassword(), UserAuthExceptions.class,"Password Name Required!");

        return true;
    }
}
