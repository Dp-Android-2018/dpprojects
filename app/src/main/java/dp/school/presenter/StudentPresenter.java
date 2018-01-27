package dp.school.presenter;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.baseconnection.WebServiceConstants;
import dp.school.request.StudentRequest;
import dp.school.response.studentresponse.StudentResponse;
import dp.school.views.StudentPresenterView;
import dp.school.views.StudentView;


public class StudentPresenter implements StudentPresenterView{
    StudentView studentView;

    public StudentPresenter(StudentView studentView){
        this.studentView= studentView;
    }

    @Override
    public void onLoginStudent(StudentRequest studentRequest) {

        ConnectionUtils.getInstance().createConnection(studentRequest, WebServiceConstants.STUDENT_LOGIN, true, true, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                studentView.onStudentLogined(new Gson().fromJson(response,StudentResponse.class));
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
