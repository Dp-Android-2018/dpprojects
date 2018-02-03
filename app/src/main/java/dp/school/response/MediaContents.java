package dp.school.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import dp.school.model.BaseContentModel;
import dp.school.model.MediaModel;

/**
 * Created by DELL on 30/01/2018.
 */

public class MediaContents extends BaseContentModel{


    @SerializedName("data")
    private ArrayList<MediaModel>data;

    public ArrayList<MediaModel> getData() {

        return data;
    }


}
