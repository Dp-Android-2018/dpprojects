package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by DELL on 03/02/2018.
 */

public class ClassModel extends BaseItemModel {

    @SerializedName("grade_id")
    private int gradeId;


    @SerializedName("title")
    private String classTitle;

    @SerializedName("students_count")
    private int studentsCount;

    @SerializedName("junctions")
    private ArrayList<Junction>junctions;

    @SerializedName("grade")
    private Grade grade;

    public int getGradeId() {
        return gradeId;
    }

    public String getClassTitle() {
        return classTitle;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public ArrayList<Junction> getJunctions() {
        return junctions;
    }

    public Grade getGrade() {
        return grade;
    }
}
