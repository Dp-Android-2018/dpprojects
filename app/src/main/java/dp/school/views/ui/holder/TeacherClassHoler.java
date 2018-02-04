package dp.school.views.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.ClassModel;

/**
 * Created by DELL on 04/02/2018.
 */

public class TeacherClassHoler extends RecyclerView.ViewHolder{
    @BindView(R.id.tv_class_name)
    TextView name;
    @BindView(R.id.tv_class_grade) TextView grade;
    @BindView(R.id.tv_class_number_of_students)TextView numberOfStudents;
    @BindView(R.id.iv_class_calender_state)ImageView calenderState;

    public TeacherClassHoler(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bindData(ClassModel classModel){
        this.name.setText(classModel.getClassTitle());
        this.grade.setText(classModel.getGrade().getTitle());
        this.numberOfStudents.setText(String.valueOf(classModel.getStudentsCount()));
    }
}
