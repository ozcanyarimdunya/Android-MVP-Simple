package org.semiworld.projects.appinmvp.login;

import android.os.Handler;
import android.text.TextUtils;


/**
 * Author:  Ozcan YARIMDUNYA
 * Date  :  08-04-2018 15:58
 */

public class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(String username, String password, final onLoginListener onLoginListener) {
        if (TextUtils.isEmpty(username))
            onLoginListener.onUsernameError();
        else if (TextUtils.isEmpty(password))
            onLoginListener.onPasswordError();
        else if (username.equals("admin") && password.equals("123")) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onLoginListener.onSuccess();
                }
            }, 3000);
        } else
            onLoginListener.onFailure("Invalid Credential");
    }
}
