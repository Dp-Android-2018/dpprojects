package dp.school.views.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.SectionTimeModel;

/**
 * Created by DELL on 04/02/2018.
 */

public class TeacherSheduleHolder extends RecyclerView.ViewHolder {

   @BindView(R.id.tv_schedule_class_name)
    TextView tvClassName;

    @BindView(R.id.tv_schedule_class_grade)
    TextView tvGrade;

    @BindView(R.id.tv_schedule_class_number_of_students)
    TextView tvNumOfStudents;


    @BindView(R.id.tv_item_schedule_from)
    TextView tvFrom;

    @BindView(R.id.tv_item_to_from)
    TextView tvTo;

    public TeacherSheduleHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void BindData(SectionTimeModel sectionTimeModel){
       this.tvClassName.setText(sectionTimeModel.getClasse());
        this.tvGrade.setText(sectionTimeModel.getGrade());
        this.tvNumOfStudents.setText(String.valueOf(sectionTimeModel.getStudentsCount()));
        tvFrom.setText(sectionTimeModel.getFrom());
        tvTo.setText(sectionTimeModel.getTo());
      /* this.tvClassName.setText("FFFFF");
        this.tvGrade.setText("GGGGG");
        this.tvNumOfStudents.setText("NNNNNNN");
        tvFrom.setText("BBBBBBBB");
        tvTo.setText("LLLLL");*/
    }
}
