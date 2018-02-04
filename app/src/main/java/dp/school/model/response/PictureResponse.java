package dp.school.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import dp.school.model.gloabal.MediaModel;
import dp.school.model.gloabal.PageLinks;
import dp.school.model.gloabal.PictureLinks;
import dp.school.model.gloabal.PictureMetaResponse;

/**
 * Created by DELL on 03/02/2018.
 */

public class PictureResponse extends PageLinks{

    @SerializedName("data")
    private ArrayList<MediaModel> data;

    public ArrayList<MediaModel> getData() {
        return data;
    }


}
