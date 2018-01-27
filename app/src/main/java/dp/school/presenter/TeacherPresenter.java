package dp.school.presenter;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.baseconnection.WebServiceConstants;
import dp.school.request.TeacherRequest;
import dp.school.response.teacherresponse.TeacherResponse;
import dp.school.views.TeacherPresenterView;
import dp.school.views.TeacherView;


public class TeacherPresenter implements TeacherPresenterView {
    TeacherView teacherView ;

    public TeacherPresenter(TeacherView teacherView){
        this.teacherView= teacherView;
    }

    @Override
    public void onLoginTeacher(TeacherRequest teacherRequest) {

        ConnectionUtils.getInstance().createConnection(teacherRequest, WebServiceConstants.TEACHER_LOGIN, true, true, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                teacherView.onTeacherLogined(new Gson().fromJson(response,TeacherResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                teacherView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return teacherView.getContext();
            }
        });
    }


}
