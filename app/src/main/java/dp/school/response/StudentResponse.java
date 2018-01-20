package dp.school.response;


import com.google.gson.annotations.SerializedName;

import dp.school.base.baseconnection.BaseResponse;

public class StudentResponse {
    private String name;
    private String className;
    private int points;

    public void setName(String name) {
        this.name = name;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public String getClassName() {
        return className;
    }

    public int getPoints() {
        return points;
    }

}