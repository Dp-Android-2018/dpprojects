package dp.school.presenter;

import android.content.Context;
import com.google.gson.Gson;
import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.baseconnection.WebServiceConstants;
import dp.school.request.ParentRequest;
import dp.school.response.parentresponse.ParentResponse;
import dp.school.views.ParentPresenterView;
import dp.school.views.ParentView;


public class ParentPresenter implements ParentPresenterView {
    ParentView parentView;

    public ParentPresenter(ParentView parentView) {
        this.parentView = parentView;
    }


    @Override
    public void onValidateParentPhone(ParentRequest parentRequest) {
        ConnectionUtils.getInstance().createConnection(parentRequest, WebServiceConstants.PARENT_LOGIN, true, true, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                parentView.onParentPhoneValidated(new Gson().fromJson(response, ParentResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                parentView.onError(code, message);
            }

            @Override
            public Context getContext() {
                return parentView.getContext();
            }
        });
    }

    @Override
    public void onValidateParentCode(String password) {
        parentView.onParentCodeValidated();
    }


}
