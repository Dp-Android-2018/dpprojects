package dp.school.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 30/01/2018.
 */

public class AboutUsModel extends BaseItemModel{


    @SerializedName("about_us")
    private String about;

    public String getAbout() {
        return about;
    }
}
