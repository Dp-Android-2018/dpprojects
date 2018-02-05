package dp.school.presenter.Implementation;

import android.content.Context;

import com.android.volley.Request;
import com.google.gson.Gson;

import dp.school.model.request.BaseRequest;
import dp.school.model.response.teacherresponse.ClassesResponse;
import dp.school.presenter.PresenterInterface.ClassPresenterIml;
import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.views.viewInterface.ClassesView;

/**
 * Created by DELL on 04/02/2018.
 */

public class ClassesPresenter implements ClassPresenterIml {

    private ClassesView classesView;
    public ClassesPresenter(ClassesView classesView) {
        this.classesView=classesView;
    }

    @Override
    public void getClassesData() {
        ConnectionUtils.getInstance().createConnection(new BaseRequest(), WebServiceConstants.CLASSES_URL, true, true, Request.Method.GET, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                classesView.getTeacherClasss(new Gson().fromJson(response, ClassesResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                classesView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return classesView.getContext();
            }
        });
    }
}
