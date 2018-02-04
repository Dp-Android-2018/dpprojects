package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 03/02/2018.
 */

public class PictureLinks {

    @SerializedName("first")
    private String first;

    @SerializedName("last")
    private String last;

    @SerializedName("prev")
    private String prev;

    @SerializedName("next")
    private String next;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getPrev() {
        return prev;
    }

    public String getNext() {
        return next;
    }
}
