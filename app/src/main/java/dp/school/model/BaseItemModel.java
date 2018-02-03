package dp.school.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 31/01/2018.
 */

public class BaseItemModel {

    @SerializedName("id")
    private int id;

    @SerializedName("created_at")
    private String createAt;

    @SerializedName("updated_at")
    private String updateAt;

    public int getId() {
        return id;
    }

    public String getCreateAt() {
        return createAt;
    }

    public String getUpdateAt() {
        return updateAt;
    }
}
