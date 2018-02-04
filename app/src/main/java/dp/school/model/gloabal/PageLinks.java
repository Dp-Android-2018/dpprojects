package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 03/02/2018.
 */

public class PageLinks {

    @SerializedName("links")
    private PictureLinks links;

    @SerializedName("meta")
    private PictureMetaResponse meta;

    public PictureLinks getLinks() {
        return links;
    }

    public PictureMetaResponse getMeta() {
        return meta;
    }
}
