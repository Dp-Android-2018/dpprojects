package dp.school.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 30/01/2018.
 */

public class MediaModel {

    @SerializedName("id")
    private int id;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("url")
    private String url;

    public int getId() {
        return id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getUrl() {
        return url;
    }
}
