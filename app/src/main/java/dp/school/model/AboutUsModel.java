package dp.school.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 30/01/2018.
 */

public class AboutUsModel {

    @SerializedName("id")
    private int id;

    @SerializedName("about_us")
    private String about;

    public int getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }
}
