package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 04/02/2018.
 */

public class SectionTimeModel {

    @SerializedName("day")
    private String day;

    @SerializedName("from")
    private String from;

    @SerializedName("to")
    private String to;

    @SerializedName("class")
    private String classe;

    @SerializedName("grade")
    private String grade;

    @SerializedName("students_count")
    private int studentsCount;

    public String getDay() {
        return day;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getClasse() {
        return classe;
    }

    public String getGrade() {
        return grade;
    }

    public int getStudentsCount() {
        return studentsCount;
    }
}
