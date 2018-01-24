package dp.school.views;


import dp.school.request.ParentRequest;

public interface ParentPresenterView {
    void onValidateParentPhone(ParentRequest parentRequest);
    void onValidateParentCode(String password);
}
