package dp.school.presenter.Implementation;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.model.request.StudentRequest;
import dp.school.model.response.studentresponse.StudentResponse;
import dp.school.presenter.PresenterInterface.StudentPresenterIml;
import dp.school.utility.utils.SharedPreferenceUtils;
import dp.school.views.viewInterface.StudentView;


public class StudentPresenter implements StudentPresenterIml {
    StudentView studentView;

    public StudentPresenter(StudentView studentView){
        this.studentView= studentView;
    }

    @Override
    public void onLoginStudent(StudentRequest studentRequest) {

        ConnectionUtils.getInstance().createConnection(studentRequest, WebServiceConstants.STUDENT_LOGIN, true, true,1, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                StudentResponse studentResponse =new Gson().fromJson(response,StudentResponse.class);
                SharedPreferenceUtils.setUserKey(studentResponse.getUser().getApiToken());
                studentView.onStudentLogined(studentResponse);
            }

            @Override
            public void onResponseError(int code, String message) {
                studentView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return studentView.getContext();
            }
        });
    }

}
