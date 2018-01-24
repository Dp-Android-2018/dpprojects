package dp.school.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Atef on 1/23/2018.
 */

public class ParentRequest {
    @SerializedName("phone")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
