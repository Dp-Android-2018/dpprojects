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

public class StudentLoginActivity extends AppCompatActivity {

    @BindView(R.id.et_student_login_password)
    EditText passwordEditText;
    @BindView(R.id.et_student_login_user_name)
    EditText userNameEditText;
    @BindView(R.id.iv_student_login_password_entered)
    ImageView passwordImageView;
    @BindView(R.id.iv_student_login_name_entered)
    ImageView userNameImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        ButterKnife.bind(this);
        setMoveAnimation();
        handelEditTextListener();
    }

    private void handelEditTextListener() {
        UIUtils.approveEnteredData(userNameEditText,userNameImageView);
        UIUtils.approveEnteredData(passwordEditText,passwordImageView);
    }

    private void setMoveAnimation(){
        ArrayList<View>animatedViews=new ArrayList<>();
        animatedViews.add(passwordEditText);
        animatedViews.add(userNameEditText);
        UIUtils.startMoveAnimation(this,animatedViews);
    }


}
