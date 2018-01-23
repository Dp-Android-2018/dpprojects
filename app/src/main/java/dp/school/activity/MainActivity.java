package dp.school.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.BindDrawable;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.base.utils.UIUtils;
import dp.school.base.views.AnimatedButtonView;
import dp.school.base.views.OnAnimatedButtonListener;

/**
 * Created by DELL on 06/12/2017.
 */

public class MainActivity extends AppCompatActivity {
    public static int TEACHER_SELECTED = 1, STUDENT_SELECTED = 2, PARENT_SELECTED = 3;
    int selectedTab = -1;

    @BindView(R.id.iv_main_teacher_image)
    ImageView teacherImage;
    @BindView(R.id.iv_main_student_image)
    ImageView studentImage;
    @BindView(R.id.iv_main_parent_image)
    ImageView parentImage;
    @BindView(R.id.v_main_reveal)
    View revealView;
    @BindView(R.id.tv_main_student_label)
    TextView studentTextView;
    @BindView(R.id.tv_main_parent_label)
    TextView parentTextView;
    @BindView(R.id.tv_main_teacher_label)
    TextView teacherTextView;
    @BindDrawable(R.drawable.btn_background_white)
    Drawable btnDrawableWhiteColor;
    @BindDrawable(R.drawable.btn_background_gray)
    Drawable btnDrawableGrayColor;
    @BindView(R.id.abv_main_login)
    AnimatedButtonView loginAnimatedButton;
    @BindView(R.id.ll_main_teacher_tab)
    LinearLayout teacherTab;
    @BindView(R.id.ll_main_parent_tab)
    LinearLayout parentTab;
    @BindView(R.id.ll_main_student_tab)
    LinearLayout studentTab;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        loginAnimatedButton.setOnAnimatedButtonListener(new OnAnimatedButtonListener() {
            @Override
            public void onAnimationEnd(final boolean isAnimationEnabled) {
                new Handler().postDelayed(new Runnable() {
                    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                    @Override
                    public void run() {
                        if (isAnimationEnabled) {
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                UIUtils.revealButton(MainActivity.this,loginAnimatedButton,revealView);
                            }
                            delayedStartNextActivity();
                        }
                    }
                }, 300);
            }
        });


        loginAnimatedButton.setBackground(btnDrawableGrayColor);

        setEvents();
    }


    private void setEvents() {
        teacherSelected();
        studentSelected();
        parentSelected();
    }


    private void teacherSelected() {
        teacherTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                parentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                teacherTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorWhite));
                selectedTab = TEACHER_SELECTED;
                teacherImage.setImageResource(R.drawable.img_un_checked_teacher);
                studentImage.setImageResource(R.drawable.img_checked_student);
                parentImage.setImageResource(R.drawable.img_checked_parent);
                loginAnimatedButton.setAnimationEnabled(R.drawable.btn_background_white);
            }
        });

    }

    private void studentSelected() {
        studentTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorWhite));
                parentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                teacherTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                selectedTab = STUDENT_SELECTED;
                teacherImage.setImageResource(R.drawable.img_checked_teacher);
                studentImage.setImageResource(R.drawable.img_un_checked_student);
                parentImage.setImageResource(R.drawable.img_checked_parent);
                loginAnimatedButton.setAnimationEnabled(R.drawable.btn_background_white);
            }
        });
    }

    private void parentSelected() {
        parentTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                studentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                parentTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorWhite));
                teacherTextView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorGray));
                selectedTab = PARENT_SELECTED;
                teacherImage.setImageResource(R.drawable.img_checked_teacher);
                studentImage.setImageResource(R.drawable.img_checked_student);
                parentImage.setImageResource(R.drawable.img_un_checked_parent);
                loginAnimatedButton.setAnimationEnabled(R.drawable.btn_background_white);
            }
        });
    }




    private void delayedStartNextActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (selectedTab == STUDENT_SELECTED) {
                    startActivity(new Intent(MainActivity.this, StudentLoginActivity.class));
                } else if (selectedTab == PARENT_SELECTED) {
                    startActivity(new Intent(MainActivity.this, ParentLoginActivity.class));
                } else if (selectedTab == TEACHER_SELECTED) {
                    startActivity(new Intent(MainActivity.this, TeacherLoginActivity.class));
                }
                finish();
            }
        }, 100);
    }

}
