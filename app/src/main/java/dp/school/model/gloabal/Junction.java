package dp.school.model.gloabal;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 03/02/2018.
 */

public class Junction extends BaseItemModel {
    @SerializedName("class_id")
    private int classId;

    @SerializedName("teacher_id")
    private int TeacherId;


    @SerializedName("subject_id")
    private int subjectId;

    public int getClassId() {
        return classId;
    }

    public int getTeacherId() {
        return TeacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }
}
