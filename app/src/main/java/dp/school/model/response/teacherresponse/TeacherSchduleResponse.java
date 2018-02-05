package dp.school.model.response.teacherresponse;

import com.google.gson.annotations.SerializedName;

import dp.school.model.gloabal.TeacherSchedule;

/**
 * Created by DELL on 04/02/2018.
 */

public class TeacherSchduleResponse {


    @SerializedName("data")
    private TeacherSchedule data;

    public TeacherSchedule getData() {
        return data;
    }
}
