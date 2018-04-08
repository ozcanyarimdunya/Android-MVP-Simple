package org.semiworld.projects.appinmvp.login;

/**
 * Author:  Ozcan YARIMDUNYA
 * Date  :  08-04-2018 15:56
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);
    void onDestroy();
}
