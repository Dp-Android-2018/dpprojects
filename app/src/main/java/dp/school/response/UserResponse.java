package dp.school.response;


import com.google.gson.annotations.SerializedName;

import dp.school.base.baseconnection.BaseResponse;

public class UserResponse extends BaseResponse {

    @SerializedName("name")
    private String name;
    @SerializedName("age")
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }


}