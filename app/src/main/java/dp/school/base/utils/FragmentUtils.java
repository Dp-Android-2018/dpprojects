package dp.school.base.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import dp.school.R;
import dp.school.base.AppController;


/**
 * Created by PC on 25/12/2017.
 */

public class FragmentUtils {
    public static final int CONTENT_VIEW_ID = R.id.frame_layout;

    public static void addFragment(Context context, Fragment fragment, String backStackString) {
        FragmentTransaction transaction = getFragmentManager(context).beginTransaction();
        if (!ValidationUtils.isEmpty(backStackString)) {
            transaction.addToBackStack(backStackString);
        }
        transaction.add(CONTENT_VIEW_ID, fragment).commit();
    }

    public static void replaceFragment(Context context, Fragment fragment, String backStackString) {
        FragmentTransaction transaction = getFragmentManager(context).beginTransaction();
        if (!ValidationUtils.isEmpty(backStackString)) {
            transaction.addToBackStack(backStackString);
        }
        transaction.replace(CONTENT_VIEW_ID, fragment).commit();
    }

    public static void removeLastFragment(Context context) {
        getFragmentManager(context).popBackStackImmediate();
    }


    public static FragmentManager getFragmentManager(Context context) {
        return ((FragmentActivity) context).getSupportFragmentManager();
    }

    public static void removeAllFragments(Context context) {
        FragmentManager fm = getFragmentManager(context);
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStack();
        }
    }
}
