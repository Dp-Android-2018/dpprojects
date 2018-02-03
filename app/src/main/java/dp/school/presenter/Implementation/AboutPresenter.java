package dp.school.presenter.Implementation;

import android.content.Context;
import android.media.browse.MediaBrowser;

import com.google.gson.Gson;

import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.baseconnection.WebServiceConstants;
import dp.school.model.MediaModel;
import dp.school.presenter.PresenterInterface.AboutPresenterInterface;
import dp.school.request.BaseRequest;
import dp.school.response.AboutUsResponse;
import dp.school.response.MediaResponse;
import dp.school.response.teacherresponse.TeacherResponse;
import dp.school.views.AboutUsView;

/**
 * Created by DELL on 30/01/2018.
 */

public class AboutPresenter implements AboutPresenterInterface {

    private AboutUsView aboutUsView;
    public AboutPresenter(AboutUsView aboutUsView) {
        this.aboutUsView=aboutUsView;
    }

    @Override
    public void getAboutData(BaseRequest baseRequest) {
        ConnectionUtils.getInstance().createConnection(baseRequest, WebServiceConstants.ABOUT_US_URL, true, true, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {

                aboutUsView.displayAboutUs(new Gson().fromJson(response,AboutUsResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                System.out.println("Error Message :"+message);
                aboutUsView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return aboutUsView.getContext();
            }
        });

    }
}
