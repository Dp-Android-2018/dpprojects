package dp.school.utility;

import android.content.Context;

/**
 * Created by PC on 20/12/2017.
 */

public interface BaseView {
    Context getContext();
    void onError(int code,String messageError);
}
