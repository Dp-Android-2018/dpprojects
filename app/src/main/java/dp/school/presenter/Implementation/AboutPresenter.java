package dp.school.presenter.Implementation;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.presenter.PresenterInterface.AboutPresenterIml;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.AboutUsResponse;
import dp.school.views.viewInterface.AboutUsView;

/**
 * Created by DELL on 30/01/2018.
 */

public class AboutPresenter implements AboutPresenterIml {

    private AboutUsView aboutUsView;
    public AboutPresenter(AboutUsView aboutUsView) {
        this.aboutUsView=aboutUsView;
    }

    @Override
    public void getAboutData(BaseRequest baseRequest) {
        ConnectionUtils.getInstance().createConnection(baseRequest, WebServiceConstants.ABOUT_US_URL, true, true,0, new ConnectionView() {
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
