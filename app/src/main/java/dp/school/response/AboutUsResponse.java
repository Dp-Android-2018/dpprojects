package dp.school.response;

import com.google.gson.annotations.SerializedName;

import dp.school.model.AboutUsModel;
import dp.school.response.teacherresponse.User;

/**
 * Created by DELL on 30/01/2018.
 */

public class AboutUsResponse {

    @SerializedName("aboutUs")
    private AboutUsModel aboutUsModel;

    public AboutUsModel getAboutUsModel() {
        return aboutUsModel;
    }
}
