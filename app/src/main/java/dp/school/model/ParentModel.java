package dp.school.model;

import android.content.Context;

import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.request.UserRequest;

/**
 * Created by Mohamed Atef on 1/20/2018.
 */

public class ParentModel {

    public void validateParent(String url, final boolean haveHeaders, final boolean showLoadingBar, final ConnectionView connectionView) {
        UserRequest userRequest=null;

        ConnectionUtils.getInstance().createConnection(userRequest, url, haveHeaders, showLoadingBar, new ConnectionView() {
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