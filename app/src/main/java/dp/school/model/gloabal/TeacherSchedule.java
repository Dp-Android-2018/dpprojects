package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by DELL on 04/02/2018.
 */

public class TeacherSchedule {

    @SerializedName("sat")
    ArrayList<SectionTimeModel> sat;

    @SerializedName("sun")
    ArrayList<SectionTimeModel> sun;

    @SerializedName("mon")
    ArrayList<SectionTimeModel> mon;

    @SerializedName("tue")
    ArrayList<SectionTimeModel> tue;

    @SerializedName("wed")
    ArrayList<SectionTimeModel> wed;

    @SerializedName("thu")
    ArrayList<SectionTimeModel> thu;

    @SerializedName("fri")
    ArrayList<SectionTimeModel> fri;

    public ArrayList<SectionTimeModel> getSat() {
        return sat;
    }

    public ArrayList<SectionTimeModel> getSun() {
        return sun;
    }

    public ArrayList<SectionTimeModel> getMon() {
        return mon;
    }

    public ArrayList<SectionTimeModel> getTue() {
        return tue;
    }

    public ArrayList<SectionTimeModel> getWed() {
        return wed;
    }

    public ArrayList<SectionTimeModel> getThu() {
        return thu;
    }

    public ArrayList<SectionTimeModel> getFri() {
        return fri;
    }
}
