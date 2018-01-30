package dp.school.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.Main2Activity;
import dp.school.R;
import dp.school.StartActivity;
import dp.school.base.utils.UIUtils;
import dp.school.base.utils.ValidationUtils;
import dp.school.base.views.AnimatedButtonView;
import dp.school.base.views.OnAnimatedButtonListener;
import dp.school.presenter.ParentPresenter;
import dp.school.views.ParentView;

public class ParentLoginActivity extends AppCompatActivity implements ParentView {

    @BindView(R.id.et_parent_login_phone)
    EditText phoneEditText;
    @BindView(R.id.iv_parent_login_phone_entered)
    ImageView phoneImageView;
    @BindView(R.id.abv_main_login)
    AnimatedButtonView loginAnimatedButton;
    ParentPresenter parentPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        ButterKnife.bind(this);
        parentPresenter = new ParentPresenter(this);
        setMoveAnimation();
        handelEditTextListener();
        setEvents();
    }

    @Override
    public void onPasswordChanged() {

    }

    @Override
    public void onParentValidated() {

    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onError(int code, String messageError) {

    }

   /* @Override
    public void onError(String messageError) {

    }*/


    private void setEvents() {
        loginAnimatedButton.setOnAnimatedButtonListener(new OnAnimatedButtonListener() {
            @Override
            public void onAnimationEnd(final boolean isAnimationEnabled) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (isAnimationEnabled) {
                            Intent intent = new Intent(ParentLoginActivity.this, StartActivity.class);
                            startActivity(intent);
                        }
                    }
                }, 50);
            }
        });
        loginAnimatedButton.setAnimationEnabled(AnimatedButtonView.NO_DRAWABLE);
    }

    private void handelEditTextListener() {
        UIUtils.approveEnteredData(phoneEditText, phoneImageView, ValidationUtils.TYPE_PHONE);
    }

    private void setMoveAnimation() {
        ArrayList<View> animatedViews = new ArrayList<>();
        animatedViews.add(phoneEditText);
        UIUtils.startMoveAnimation(this, animatedViews);
    }
}
