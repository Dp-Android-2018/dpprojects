package dp.school.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.base.utils.UIUtils;

public class TeacherLoginActivity extends AppCompatActivity {

    @BindView(R.id.et_teacher_login_phone)
    EditText phoneEditText;
    @BindView(R.id.iv_teacher_login_phone_entered)
    ImageView phoneImageView;
    @BindView(R.id.et_teacher_login_password)
    EditText passwordEditText;
    @BindView(R.id.iv_teacher_login_password_entered)
    ImageView passwordImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);
        ButterKnife.bind(this);
        setMoveAnimation();
        UIUtils.approveEnteredData(phoneEditText,phoneImageView);
        UIUtils.approveEnteredData(passwordEditText,passwordImageView);
    }


    private void setMoveAnimation(){
        ArrayList<View> animatedViews=new ArrayList<>();
        animatedViews.add(phoneEditText);
        animatedViews.add(passwordEditText);
        UIUtils.startMoveAnimation(this,animatedViews);
    }

}
