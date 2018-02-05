package dp.school.utility.utils;

import android.content.Context;
import android.content.SharedPreferences;

import dp.school.utility.AppController;
import com.google.gson.Gson;


public class SharedPreferenceUtils {

    public static  void saveObjectToSharedPreferences(String sharedPreferenceName, String savedObjectName, Object object) {
        SharedPreferences sharedPreferences = AppController.getContext().getSharedPreferences(
                "SharedPreferenceDetails", Context.MODE_PRIVATE);
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

    public static void setUserKey(String key){
        SharedPreferences sharedPreferences = AppController.getContext().getSharedPreferences(
                "userKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userKey",key);
        editor.commit();

    }

    public static String getUserKey(){
        return AppController.getContext().getSharedPreferences(
                "userKey", Context.MODE_PRIVATE).getString("userKey","");
    }

    public static void clearSharedPreference(){
      SharedPreferences sharedPreferences = AppController.getContext().getSharedPreferences("SharedPreferenceDetails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        editor.apply();
     //   SharedPreferences.Editor.cl.commit();

    }

}
