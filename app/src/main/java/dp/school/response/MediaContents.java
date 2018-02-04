package dp.school.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import dp.school.model.AboutUsModel;
import dp.school.model.MediaModel;

/**
 * Created by DELL on 30/01/2018.
 */

public class MediaContents {

    @SerializedName("current_page")
    private int currentPage;

    @SerializedName("data")
    private ArrayList<MediaModel>data;


    public int getCurrentPage() {
        return currentPage;
    }

    public ArrayList<MediaModel> getData() {
        return data;
    }
}
