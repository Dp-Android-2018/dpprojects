package dp.school.model.response;

import com.google.gson.annotations.SerializedName;

import dp.school.model.gloabal.AboutUsModel;

/**
 * Created by DELL on 30/01/2018.
 */

public class AboutUsResponse {

    @SerializedName("data")
    private AboutUsModel aboutUsModel;

    public AboutUsModel getAboutUsModel() {
        return aboutUsModel;
    }
}
