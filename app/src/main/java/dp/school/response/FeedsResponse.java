package dp.school.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 31/01/2018.
 */

public class FeedsResponse {

    @SerializedName(value = "feeds")
    private FeedsContents feeds;

    public FeedsContents getFeeds() {
        return feeds;
    }
}
