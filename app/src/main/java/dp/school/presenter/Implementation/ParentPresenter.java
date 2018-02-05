package dp.school.presenter.Implementation;

import android.content.Context;

import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.model.request.ParentRequest;
import dp.school.presenter.PresenterInterface.ParentPresenterIml;
import dp.school.views.viewInterface.ParentView;


public class ParentPresenter implements ParentPresenterIml {
    ParentView parentView ;

    public ParentPresenter (ParentView parentView){
        this.parentView = parentView;
    }

    @Override
    public void onValidateParentPhone(ParentRequest parentRequest) {
        ConnectionUtils.getInstance().createConnection(parentRequest, "url", true, true,1, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                parentView.onParentCodeValidated();
            }

            @Override
            public void onResponseError(int code, String message) {
             parentView.onError(code,message);
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
