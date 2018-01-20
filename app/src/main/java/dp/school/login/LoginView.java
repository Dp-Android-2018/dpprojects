package dp.school.login;


import dp.school.base.BaseView;

/**
 * Created by PC on 19/12/2017.
 */

public interface LoginView extends BaseView {
    void onUserLogin();
    void onShowError(String message);
}
