package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 03/02/2018.
 */

public class Grade {

    @SerializedName("title")
    private String title;

    @SerializedName("id")
    private int id;

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}
