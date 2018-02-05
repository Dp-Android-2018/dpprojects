package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by DELL on 31/01/2018.
 */

public class FeedModel extends BaseItemModel implements Serializable {
    @SerializedName("title")
    private String title;

    @SerializedName("sub_title")
    private String subTitle;

    @SerializedName("image")
    private String image;

    @SerializedName("details")
    private String details;

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public String getImage() {
        return image;
    }

    public String getDetails() {
        return details;
    }

}
