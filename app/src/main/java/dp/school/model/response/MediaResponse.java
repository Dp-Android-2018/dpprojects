package dp.school.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 30/01/2018.
 */

public class MediaResponse {
    @SerializedName("videos")
    private MediaContents media;

    public MediaContents getMedia() {
        return media;
    }
}
