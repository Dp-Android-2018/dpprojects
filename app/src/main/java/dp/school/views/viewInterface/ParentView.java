package dp.school.views.viewInterface;


import dp.school.utility.BaseView;
import dp.school.model.response.parentresponse.ParentResponse;

public interface ParentView extends BaseView{
    void onParentPhoneValidated(ParentResponse parentResponse);
    void onParentCodeValidated();
}
