package dp.school.base.utils;

import android.content.Context;
import android.content.SharedPreferences;
import dp.school.R;
import dp.school.base.AppController;
import com.google.gson.Gson;


public class SharedPreferenceUtils {

    public static  void saveObjectToSharedPreferences(String sharedPreferenceName, String savedObjectName, Object object) {
        SharedPreferences sharedPreferences = AppController.getContext().getSharedPreferences(
                sharedPreferenceName, Context.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        prefsEditor.putString(savedObjectName, json);
        prefsEditor.commit();
    }

    public static Object getSavedObject(String sharedPreferenceName, String savedObjectName, Class objectClass) {
        SharedPreferences sharedPreferences = AppController.getContext().getSharedPreferences(
                sharedPreferenceName, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString(savedObjectName, "");
        return gson.fromJson(json, objectClass);
    }

    public static void clearSharedPreference(String sharedPreferenceName){
        SharedPreferences sharedPreferences = AppController.getContext().getSharedPreferences(sharedPreferenceName,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        editor.apply();

    }
}
