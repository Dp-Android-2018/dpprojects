package dp.school.model.request;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohamed Atef on 1/23/2018.
 */

public class TeacherRequest  {

    @SerializedName("phone")
    private String phone;

    @SerializedName("password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
