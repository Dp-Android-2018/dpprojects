package dp.school.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 30/01/2018.
 */

public class MediaModel extends BaseItemModel {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }
}
