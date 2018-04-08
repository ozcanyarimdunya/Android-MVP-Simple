package org.semiworld.projects.appinmvp.login;

/**
 * Author:  Ozcan YARIMDUNYA
 * Date  :  08-04-2018 15:55
 */

public interface LoginInteractor {
    interface onLoginListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void onFailure(String message);
    }

    void login(String username, String password, onLoginListener onLoginListener);
}
