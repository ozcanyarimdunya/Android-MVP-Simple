package org.semiworld.projects.appinmvp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.semiworld.projects.appinmvp.MainActivity;
import org.semiworld.projects.appinmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText edUsername, edPassword;
    private Button btnLogin;
    private ProgressBar mPbLoad;

    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mLoginPresenter = new LoginPresenterImpl(this);

        edUsername = findViewById(R.id.edUsername);
        edPassword = findViewById(R.id.edPassword);
        btnLogin = findViewById(R.id.btnLogin);
        mPbLoad = findViewById(R.id.pbLoad);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginPresenter.validateCredentials(edUsername.getText().toString(), edPassword.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        mPbLoad.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mPbLoad.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        edUsername.setError("Username can not be empty!");
    }

    @Override
    public void setPasswordError() {
        edPassword.setError("Password can not be empty!");
    }

    @Override
    public void navigateToMain() {
        startActivity(new Intent(LoginActivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
