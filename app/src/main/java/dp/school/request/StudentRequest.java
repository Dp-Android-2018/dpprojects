package dp.school.request;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Atef on 1/23/2018.
 */

public class StudentRequest {

    @SerializedName("ssn")
    private String ssn;

    @SerializedName("password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getSsn() {
        return ssn;
    }
}
