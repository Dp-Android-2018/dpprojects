package dp.school.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.base.utils.SharePreferenceConstants;
import dp.school.base.utils.SharedPreferenceUtils;
import dp.school.base.utils.UIUtils;
import dp.school.base.utils.ValidationUtils;
import dp.school.base.views.AnimatedButtonView;
import dp.school.presenter.TeacherPresenter;
import dp.school.request.TeacherRequest;
import dp.school.response.teacherresponse.TeacherResponse;
import dp.school.views.TeacherView;

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
    }

    private void login() {
        TeacherRequest teacherRequest = new TeacherRequest();
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
        SharedPreferenceUtils.saveObjectToSharedPreferences(SharePreferenceConstants.PREF_TEACHER, SharePreferenceConstants.PREF_TEACHER, teacherResponse);
        Toast.makeText(this, "" + teacherResponse.getUser().getName(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return TeacherLoginActivity.this;
    }

    @Override
    public void onError(int code ,String messageError) {
        Toast.makeText(this, ""+code, Toast.LENGTH_SHORT).show();
    }
}
