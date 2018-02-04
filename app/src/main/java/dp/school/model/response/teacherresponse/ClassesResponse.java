package dp.school.model.response.teacherresponse;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import dp.school.model.gloabal.ClassModel;

/**
 * Created by DELL on 03/02/2018.
 */

public class ClassesResponse {

    @SerializedName("classes")
    private ArrayList<ClassModel>classes;

    public ArrayList<ClassModel> getClasses() {
        return classes;
    }
}
