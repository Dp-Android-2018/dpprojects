package dp.school.views.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
import dp.school.presenter.Implementation.ParentPresenter;
import dp.school.model.request.ParentRequest;
import dp.school.model.response.parentresponse.ParentResponse;
import dp.school.views.viewInterface.ParentView;

public class ParentLoginActivity extends AppCompatActivity implements ParentView {

    String code = null;
    boolean validated=false;
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
    @BindView(R.id.tv_parent_login_sms_message)
    TextView smsMessageTextView;

    ParentPresenter parentPresenter;
    ParentResponse parentResponse;
    ParentRequest parentRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_login);
        ButterKnife.bind(this);
        parentPresenter = new ParentPresenter(this);
        setMoveAnimation();
        handelEditTextListener();
        setEvents();
        autoLogin();
    }


    @Override
    public void onParentPhoneValidated(ParentResponse parentResponse) {
        this.parentResponse = parentResponse;
        code = parentResponse.getUser().getCode();
        phoneContainerLayout.setVisibility(View.GONE);
        passwordContainerLayout.setVisibility(View.VISIBLE);
        if(parentRequest!=null) {
            smsMessageTextView.setText(getResources().getString(R.string.msg_have_sms) + " " + parentRequest.getPhone());
            smsMessageTextView.setVisibility(View.VISIBLE);
            loginAnimatedButton.setTitle(getResources().getString(R.string.action_login));
        }
        validated=true;
    }

    @Override
    public void onParentCodeValidated() {
        if(parentRequest!=null) {
            SharedPreferenceUtils.saveObjectToSharedPreferences(SharePreferenceConstants.PREF_PARENT, SharePreferenceConstants.PREF_PARENT, parentRequest);
        }
    }

    @Override
    public Context getContext() {
        return ParentLoginActivity.this;
    }

    @Override
    public void onError(int code, String messageError) {
        if (code == 401) {
            UIUtils.showSweetAlertDialog(ParentLoginActivity.this, SweetAlertDialog.ERROR_TYPE, getResources().getString(R.string.msg_wrong_password));
        }
    }

    private void setEvents() {
        loginAnimatedButton.getButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validated){
                    if(passwordEditText.getText().toString().equals(parentResponse.getUser().getCode())) {
                        parentPresenter.onValidateParentCode(passwordEditText.getText() + "");
                        SharedPreferenceUtils.setUserKey(parentResponse.getUser().getApiToken());
                    }else {
                        UIUtils.showSweetAlertDialog(ParentLoginActivity.this,SweetAlertDialog.ERROR_TYPE,getResources().getString(R.string.msg_wrong_code));
                    }
                }else {
                    parentRequest = new ParentRequest();
                    parentRequest.setPhone(phoneEditText.getText() + "");
                    parentPresenter.onValidateParentPhone(parentRequest);
                }
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

    private void autoLogin(){
        parentRequest = (ParentRequest) SharedPreferenceUtils.getSavedObject(SharePreferenceConstants.PREF_PARENT, SharePreferenceConstants.PREF_PARENT,ParentRequest.class);
        if(parentRequest!=null) {
            parentPresenter.onValidateParentPhone(parentRequest);
        }
    }
}
