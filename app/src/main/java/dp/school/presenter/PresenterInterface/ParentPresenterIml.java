package dp.school.presenter.PresenterInterface;


import dp.school.model.request.ParentRequest;

public interface ParentPresenterIml {
    void onValidateParentPhone(ParentRequest parentRequest);
    void onValidateParentCode(String password);
}
