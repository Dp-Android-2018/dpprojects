package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 03/02/2018.
 */

public class PictureMetaResponse {

    @SerializedName("current_page")
    private int currentPage;

    @SerializedName("from")
    private int from;

    @SerializedName("last_page")
    private int lastPage;

    @SerializedName("path")
    private String path;

    @SerializedName("per_page")
    private int perPage;

    @SerializedName("to")
    private int to;

    @SerializedName("total")
    private int total;

    public int getCurrentPage() {
        return currentPage;
    }

    public int getFrom() {
        return from;
    }

    public int getLastPage() {
        return lastPage;
    }

    public String getPath() {
        return path;
    }

    public int getPerPage() {
        return perPage;
    }

    public int getTo() {
        return to;
    }

    public int getTotal() {
        return total;
    }
}
