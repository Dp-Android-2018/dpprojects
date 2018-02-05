package dp.school.presenter.Implementation;

import android.content.Context;

import com.android.volley.Request;
import com.google.gson.Gson;

import dp.school.model.gloabal.ScheduleResponse;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.teacherresponse.TeacherSchduleResponse;
import dp.school.presenter.PresenterInterface.SchedulePresenterIml;
import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.views.viewInterface.ScheduleView;

/**
 * Created by DELL on 04/02/2018.
 */

public class SchedulePresenter implements SchedulePresenterIml {

    private ScheduleView scheduleView;

    public SchedulePresenter(ScheduleView scheduleView) {
        this.scheduleView=scheduleView;
    }

    @Override
    public void getTeacherSchedule() {
        ConnectionUtils.getInstance().createConnection(new BaseRequest(), WebServiceConstants.SCHEDULE_URL, true, true, Request.Method.GET, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                scheduleView.onTeacherScheduleLoaded(new Gson().fromJson(response, TeacherSchduleResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                scheduleView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return scheduleView.getContext();
            }
        });
    }
}
