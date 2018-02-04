package dp.school.utility.utils;

import android.app.Activity;
import android.content.Intent;

/**
 * Created by PC on 26/12/2017.
 */

public class ActivitiesUtils {

    public static int ACTIVITY_FINISH_ALL_ACTIVITIES, ACTIVITY_FINISH_CURRENT_ACTIVITY, ACTIVITY_START_WITHOUT_FINISH;



    private static void startActivity(int addActivityCases, Activity currentActivity, Class nextActivity,boolean withOutAnimation) {
        if (ACTIVITY_FINISH_ALL_ACTIVITIES == addActivityCases) {
            currentActivity.finish();
        } else if (ACTIVITY_FINISH_ALL_ACTIVITIES == addActivityCases) {
            currentActivity.finishAffinity();
        }
        Intent intent = new Intent(currentActivity, nextActivity);
        if(withOutAnimation){
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        }
        currentActivity.startActivity(intent);
    }

    public static void startActivityWithoutAnimation(int addActivityCases, Activity currentActivity, Class nextActivity) {
        startActivity(addActivityCases,currentActivity,nextActivity,true);
    }

    public static void startActivity(int addActivityCases, Activity currentActivity, Class nextActivity) {
        startActivity(addActivityCases,currentActivity,nextActivity,false);
    }
}
