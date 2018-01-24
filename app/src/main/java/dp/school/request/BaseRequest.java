package dp.school.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Atef on 1/23/2018.
 */

public class BaseRequest {
    @SerializedName("api_token")
    String apiToken;

    public void setApiToken(String apiToken) {
        this.apiToken = apiToken;
    }

    public String getApiToken() {
        return apiToken;
    }
}
