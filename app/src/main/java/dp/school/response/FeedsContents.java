package dp.school.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import dp.school.model.BaseContentModel;
import dp.school.model.FeedModel;
import dp.school.model.MediaModel;

/**
 * Created by DELL on 31/01/2018.
 */

public class FeedsContents extends BaseContentModel{


    @SerializedName("data")
    private ArrayList<FeedModel> data;



    public ArrayList<FeedModel> getData() {
        return data;
    }
}
