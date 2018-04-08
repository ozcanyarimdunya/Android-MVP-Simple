package org.semiworld.projects.appinmvp.login;

/**
 * Author:  Ozcan YARIMDUNYA
 * Date  :  08-04-2018 16:01
 */

public class LoginPresenterImpl implements LoginPresenter {
    private LoginView mLoginView;
    private LoginInteractor mLoginInteractor;


    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        this.mLoginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginInteractor.login(username, password, new LoginInteractor.onLoginListener() {
                @Override
                public void onUsernameError() {
                    mLoginView.hideProgress();
                    mLoginView.setUsernameError();
                }

                @Override
                public void onPasswordError() {
                    mLoginView.hideProgress();
                    mLoginView.setPasswordError();
                }

                @Override
                public void onSuccess() {
                    mLoginView.hideProgress();
                    mLoginView.navigateToMain();
                }

                @Override
                public void onFailure(String message) {
                    mLoginView.hideProgress();
                    mLoginView.showAlert(message);
                }
            });
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView = null;
        }
    }

}
