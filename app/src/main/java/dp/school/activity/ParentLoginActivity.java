package dp.school.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.StartActivity;
import dp.school.base.utils.SharePreferenceConstants;
import dp.school.base.utils.SharedPreferenceUtils;
import dp.school.base.utils.UIUtils;
import dp.school.base.utils.ValidationUtils;
import dp.school.base.views.AnimatedButtonView;
import dp.school.base.views.OnAnimatedButtonListener;
import dp.school.presenter.ParentPresenter;
import dp.school.request.ParentRequest;
import dp.school.response.parentresponse.ParentResponse;
import dp.school.views.ParentView;

public class ParentLoginActivity extends AppCompatActivity implements ParentView {

    String code = null;

    @BindView(R.id.et_parent_login_password)
    EditText passwordEditText;
    @BindView(R.id.iv_parent_login_password_entered)
    ImageView passwordImageView;


    @BindView(R.id.rl_parent_phone_container)
    RelativeLayout phoneContainerLayout;
    @BindView(R.id.rl_parent_password_container)
    RelativeLayout passwordContainerLayout;

    @BindView(R.id.et_parent_login_phone)
    EditText phoneEditText;
    @BindView(R.id.iv_parent_login_phone_entered)
    ImageView phoneImageView;

    @BindView(R.id.abv_main_login)
    AnimatedButtonView loginAnimatedButton;
    ParentPresenter parentPresenter;

    ParentResponse parentResponse;

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
    public void onParentPhoneValidated(ParentResponse parentResponse) {
        this.parentResponse = parentResponse;
        code = parentResponse.getUser().getCode();
        phoneContainerLayout.setVisibility(View.GONE);
        passwordContainerLayout.setVisibility(View.VISIBLE);
        ;
    }

    @Override
    public void onParentCodeValidated() {
        SharedPreferenceUtils.saveObjectToSharedPreferences(SharePreferenceConstants.PREF_PARENT, SharePreferenceConstants.PREF_PARENT, parentResponse);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void onError(int code, String messageError) {

    }

    private void setEvents() {
        loginAnimatedButton.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParentRequest parentRequest = new ParentRequest();
                parentRequest.setPhone(phoneEditText.getText() + "");
                parentPresenter.onValidateParentPhone(parentRequest);
            }
        });
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
