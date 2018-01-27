package dp.school.presenter;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dp.school.R;
import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.utils.ValidationUtils;
import dp.school.login.LoginView;
import dp.school.request.UserRequest;
import dp.school.response.UserResponse;

/**
 * Created by PC on 19/12/2017.
 */

public class LoginPresenter {

    LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    public void loginUser(final UserRequest userRequest) {
        if(ValidationUtils.isMail(userRequest.getName())){
            loginView.onShowError(loginView.getContext().getResources().getString(R.string.app_name));
        }

        ConnectionUtils.getInstance().createConnection(userRequest,"",false,true, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                Gson gson = new Gson();
                UserResponse userResponse = gson.fromJson(response, new TypeToken<UserResponse>(){}.getType());
                loginView.onUserLogin();
            }

            @Override
            public void onResponseError(int code,String message) {

            }

            @Override
            public Context getContext() {
                return loginView.getContext();
            }
        });
    }

}
