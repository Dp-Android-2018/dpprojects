package dp.school.model.gloabal;

import android.content.Context;

import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.model.request.UserRequest;

/**
 * Created by Mohamed Atef on 1/20/2018.
 */

public class BahaModel {

    public void getUserData(String url, final boolean haveHeaders, final boolean showLoadingBar, final ConnectionView connectionView) {
        UserRequest userRequest=null;

        ConnectionUtils.getInstance().createConnection(userRequest, url, haveHeaders, showLoadingBar,1, new ConnectionView() {
            @Override
            public void onResponseSuccess(String response) {
                connectionView.onResponseSuccess(response);
            }

            @Override
            public void onResponseError(int code, String message) {
                connectionView.onResponseError(code, message);
            }

            @Override
            public Context getContext() {
                return connectionView.getContext();
            }
        });
    }
}
