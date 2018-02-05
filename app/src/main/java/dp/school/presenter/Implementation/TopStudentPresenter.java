package dp.school.presenter.Implementation;

import android.content.Context;

import com.android.volley.Request;
import com.google.gson.Gson;

import dp.school.model.request.BaseRequest;
import dp.school.model.response.AboutUsResponse;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;
import dp.school.presenter.PresenterInterface.AboutPresenterIml;
import dp.school.presenter.PresenterInterface.TopStudentPresenterIml;
import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.views.viewInterface.AboutUsView;
import dp.school.views.viewInterface.TopStudentView;

/**
 * Created by DELL on 30/01/2018.
 */

public class TopStudentPresenter implements TopStudentPresenterIml{

    private TopStudentView topStudentView;
    public TopStudentPresenter(TopStudentView topStudentView) {
        this.topStudentView=topStudentView;
    }


    @Override
    public void getTopStudentData(BaseRequest baseRequest) {
        ConnectionUtils.getInstance().createConnection(baseRequest, WebServiceConstants.TOP_STUDENTS_URL+"2/level", true, false, Request.Method.GET, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                topStudentView.displayTopStudents(new Gson().fromJson(response,TopStudentResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                System.out.println("Error Message :"+message);
                topStudentView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return topStudentView.getContext();
            }
        });
    }
}
