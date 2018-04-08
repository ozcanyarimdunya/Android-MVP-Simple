package org.semiworld.projects.appinmvp.login;

/**
 * Author:  Ozcan YARIMDUNYA
 * Date  :  08-04-2018 15:57
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToMain();

    void showAlert(String message);
}
