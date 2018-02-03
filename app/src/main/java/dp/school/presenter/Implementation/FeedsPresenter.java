package dp.school.presenter.Implementation;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.baseconnection.WebServiceConstants;
import dp.school.presenter.PresenterInterface.FeedsPresenterIml;
import dp.school.request.BaseRequest;
import dp.school.response.FeedsResponse;
import dp.school.views.FeedsView;

/**
 * Created by DELL on 31/01/2018.
 */

public class FeedsPresenter implements FeedsPresenterIml {

    private FeedsView feedsView;
    public FeedsPresenter(FeedsView feedsView) {
        this.feedsView=feedsView;
    }

    @Override
    public void getFeedsData(BaseRequest baseRequest) {
        ConnectionUtils.getInstance().createConnection(baseRequest, WebServiceConstants.FEEDS_URL, true, false, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                feedsView.onFeedsDataLoaded(new Gson().fromJson(response, FeedsResponse.class));
            }

            @Override
            public void onResponseError(int code, String message) {
                feedsView.onError(code,message);
            }

            @Override
            public Context getContext() {
                return feedsView.getContext();
            }
        });
    }
}
