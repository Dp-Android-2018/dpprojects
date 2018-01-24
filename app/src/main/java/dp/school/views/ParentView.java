package dp.school.views;


import dp.school.base.BaseView;
import dp.school.response.parentresponse.ParentResponse;

public interface ParentView extends BaseView{
    void onParentPhoneValidated(ParentResponse parentResponse);
    void onParentCodeValidated();
}
