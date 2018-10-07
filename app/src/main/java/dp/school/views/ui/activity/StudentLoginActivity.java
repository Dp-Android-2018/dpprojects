package dp.school.views.ui.activity;

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
import cn.pedant.SweetAlert.SweetAlertDialog;
import dp.school.R;
import dp.school.utility.utils.SharePreferenceConstants;
import dp.school.utility.utils.SharedPreferenceUtils;
import dp.school.utility.utils.UIUtils;
import dp.school.utility.utils.ValidationUtils;
import dp.school.utility.views.AnimatedButtonView;
import dp.school.presenter.Implementation.StudentPresenter;
import dp.school.model.request.StudentRequest;
import dp.school.model.response.studentresponse.StudentResponse;
import dp.school.views.viewInterface.StudentView;

public class StudentLoginActivity extends AppCompatActivity implements StudentView{

    @BindView(R.id.et_student_login_password)
    EditText passwordEditText;
    @BindView(R.id.et_student_login_ssn)
    EditText ssnEditText;
    @BindView(R.id.iv_student_login_ssn_entered)
    ImageView ssnImageView;
    @BindView(R.id.iv_student_login_password_entered)
    ImageView passwordImageView;
    @BindView(R.id.abv_student_login)
    AnimatedButtonView loginAnimatedButton;

    StudentPresenter studentPresenter ;
    StudentRequest studentRequest=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        ButterKnife.bind(this);
        studentPresenter = new StudentPresenter(this);
        setMoveAnimation();
        handelEditTextListener();
        setEvents();
        autoLogin();
    }

    private void handelEditTextListener() {
        UIUtils.approveEnteredData(ssnEditText,ssnImageView, ValidationUtils.TYPE_TEXT);
        UIUtils.approveEnteredData(passwordEditText,passwordImageView, ValidationUtils.TYPE_PASSWORD);
    }

    private void setMoveAnimation() {
        ArrayList<View> animatedViews = new ArrayList<>();
        animatedViews.add(passwordEditText);
        animatedViews.add(ssnEditText);
        UIUtils.startMoveAnimation(this, animatedViews);
    }

    private void setEvents(){
        enterButtonEvent();
    }

    private void login(){
         studentRequest = new StudentRequest();
        studentRequest.setPassword(passwordEditText.getText()+"");
        studentRequest.setSsn(ssnEditText.getText()+"");
        studentPresenter.onLoginStudent(studentRequest);
    }

    private void enterButtonEvent(){
        loginAnimatedButton.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    @Override
    public Context getContext() {
        return StudentLoginActivity.this;
    }

    @Override
    public void onError(int code, String messageError) {
        if(code==401) {
         UIUtils.showSweetAlertDialog(StudentLoginActivity.this, SweetAlertDialog.ERROR_TYPE,getResources().getString(R.string.msg_wrong_password));
        }
    }

    @Override
    public void onStudentLogined(StudentResponse studentResponse) {
        if(studentRequest!=null)
        SharedPreferenceUtils.saveObjectToSharedPreferences(SharePreferenceConstants.PREF_STUDENT,studentRequest);
        Toast.makeText(this, ""+studentResponse.getUser().getImage(), Toast.LENGTH_SHORT).show();
    }
    private void autoLogin(){
        studentRequest = (StudentRequest)SharedPreferenceUtils.getSavedObject(SharePreferenceConstants.PREF_STUDENT,StudentRequest.class);
        studentPresenter.onLoginStudent(studentRequest);
    }

}
