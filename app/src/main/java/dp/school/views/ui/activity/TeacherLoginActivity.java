package dp.school.views.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import cn.pedant.SweetAlert.SweetAlertDialog;
import dp.school.views.ui.activity.MainActivity;
import dp.school.R;
import dp.school.utility.utils.SharePreferenceConstants;
import dp.school.utility.utils.SharedPreferenceUtils;
import dp.school.utility.utils.UIUtils;
import dp.school.utility.utils.ValidationUtils;
import dp.school.utility.views.AnimatedButtonView;
import dp.school.presenter.Implementation.TeacherPresenter;
import dp.school.model.request.TeacherRequest;
import dp.school.model.response.teacherresponse.TeacherResponse;
import dp.school.views.viewInterface.TeacherView;

public class TeacherLoginActivity extends AppCompatActivity implements TeacherView {

    @BindView(R.id.et_teacher_login_phone)
    EditText phoneEditText;
    @BindView(R.id.iv_teacher_login_phone_entered)
    ImageView phoneImageView;
    @BindView(R.id.et_teacher_login_password)
    EditText passwordEditText;
    @BindView(R.id.iv_teacher_login_password_entered)
    ImageView passwordImageView;
    @BindView(R.id.abv_teacher_login)
    AnimatedButtonView loginAnimatedButton;
    TeacherPresenter teacherPresenter;
    TeacherRequest teacherRequest=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        ButterKnife.bind(this);
        setMoveAnimation();
        teacherPresenter = new TeacherPresenter(this);
        UIUtils.approveEnteredData(phoneEditText, phoneImageView, ValidationUtils.TYPE_PHONE);
        UIUtils.approveEnteredData(passwordEditText, passwordImageView, ValidationUtils.TYPE_PASSWORD);
        setEvents();
        autoLogin();
    }

    private void login() {
        teacherRequest = new TeacherRequest();
        teacherRequest.setPhone(phoneEditText.getText() + "");
        teacherRequest.setPassword(passwordEditText.getText() + "");
        teacherPresenter.onLoginTeacher(teacherRequest);
    }


    private void setEvents() {
      loginAnimatedButton.getButton().setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              login();
          }
      });
    }

    private void setMoveAnimation() {
        ArrayList<View> animatedViews = new ArrayList<>();
        animatedViews.add(phoneEditText);
        animatedViews.add(passwordEditText);
        UIUtils.startMoveAnimation(this, animatedViews);
    }

    @Override
    public void onTeacherLogined(TeacherResponse teacherResponse) {
        if(teacherRequest!=null)
        SharedPreferenceUtils.saveObjectToSharedPreferences( SharePreferenceConstants.PREF_TEACHER, teacherRequest);
        Intent intent = new Intent(TeacherLoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public Context getContext() {
        return TeacherLoginActivity.this;
    }

    @Override
    public void onError(int code ,String messageError) {
        if(code==401) {
            UIUtils.showSweetAlertDialog(TeacherLoginActivity.this, SweetAlertDialog.ERROR_TYPE,getResources().getString(R.string.msg_wrong_password));
        }
        Intent intent = new Intent(TeacherLoginActivity.this, MainActivity.class);
        startActivity(intent);
    }
    private void autoLogin(){
        teacherRequest = (TeacherRequest) SharedPreferenceUtils.getSavedObject(SharePreferenceConstants.PREF_TEACHER,TeacherRequest.class);
        if(teacherRequest!=null)
            teacherPresenter.onLoginTeacher(teacherRequest);
    }
}
