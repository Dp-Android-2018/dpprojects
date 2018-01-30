package dp.school.presenter;

import android.content.Context;

import dp.school.base.baseconnection.ConnectionManager;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.views.ParentPresenterView;
import dp.school.views.ParentView;


public class ParentPresenter implements ParentPresenterView {
    ParentView parentView ;

    public ParentPresenter (ParentView parentView){
        this.parentView = parentView;
    }

    @Override
    public void onValidateParent(String phone) {
        ConnectionManager.getInstance().createConnection(phone, "url", true, true, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                parentView.onParentValidated();
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
    public void onChangeParentPassword(String password) {

        parentView.onPasswordChanged();
    }
}
