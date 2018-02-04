package dp.school.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import dp.school.model.gloabal.BaseContentModel;
import dp.school.model.gloabal.FeedModel;
import dp.school.model.gloabal.PageLinks;

/**
 * Created by DELL on 31/01/2018.
 */

public class FeedsResponse extends PageLinks{


    @SerializedName("data")
    private ArrayList<FeedModel> data;



    public ArrayList<FeedModel> getData() {
        return data;
    }
}
