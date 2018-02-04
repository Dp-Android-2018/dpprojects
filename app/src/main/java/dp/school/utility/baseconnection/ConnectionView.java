package dp.school.utility.baseconnection;


import android.content.Context;

/**
 * Created by PC on 19/12/2017.
 */

public interface ConnectionView {
    void onResponseSuccess(String response);
    void onResponseError(int code, String message);
    Context getContext();
}
