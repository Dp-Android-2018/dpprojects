package dp.school.presenter;

import android.content.Context;

import dp.school.views.ParentPresenterView;
import dp.school.views.ParentView;


public class ParentPresenter implements ParentPresenterView {
    ParentView parentView ;

    public ParentPresenter (ParentView parentView){
        this.parentView = parentView;
    }

    @Override
    public void onValidateParent(String phone) {
        parentView.onParentValidated();
    }

    @Override
    public void onChangeParentPassword(String password) {
        parentView.onPasswordChanged();
    }
}
