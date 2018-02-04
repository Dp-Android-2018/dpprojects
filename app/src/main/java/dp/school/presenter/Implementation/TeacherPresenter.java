package dp.school.presenter.Implementation;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.model.request.TeacherRequest;
import dp.school.model.response.teacherresponse.TeacherResponse;
import dp.school.presenter.PresenterInterface.TeacherPresenterIml;
import dp.school.views.viewInterface.TeacherView;


public class TeacherPresenter implements TeacherPresenterIml {
    TeacherView teacherView ;

    public TeacherPresenter(TeacherView teacherView){
        this.teacherView= teacherView;
    }

    @Override
    public void onLoginTeacher(TeacherRequest teacherRequest) {

        ConnectionUtils.getInstance().createConnection(teacherRequest, WebServiceConstants.TEACHER_LOGIN, true, true,1, new ConnectionView() {
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
