package dp.school.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import dp.school.R;
import dp.school.login.LoginView;


public class LoginActivity extends AppCompatActivity implements LoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onUserLogin() {

    }

    @Override
    public void onShowError(String message) {

    }
}
