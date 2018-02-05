package dp.school.views.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.response.teacherresponse.TeacherScheduleResponse;
import dp.school.model.response.topstudentsresponse.TopStudentItem;


public class TopStudentDetailsActivity extends AppCompatActivity {

    @BindView(R.id.tv_student_details_class)
    TextView classTextView;
    @BindView(R.id.tv_student_details_name)
    TextView nameTextView;
    @BindView(R.id.tv_student_details_points)
    TextView pointsTextView;
    @BindView(R.id.tv_student_details_attendance_points)
    TextView attendancePointsTextView;
    @BindView(R.id.tv_student_details_student_of_day_points)
    TextView studentOfDayPointsTextView;
    @BindView(R.id.tv_student_details_quiz_points)
    TextView quizPointsTextView;
    @BindView(R.id.tv_student_details_activities_points)
    TextView activitiesPointsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_student_details);
        ButterKnife.bind(this);
        setStudentDetails();
    }

    private void setStudentDetails(){
        TopStudentItem topStudentItem =  new Gson().fromJson(getIntent().getStringExtra("topStudentDetails"),TopStudentItem.class);
        classTextView.setText(topStudentItem.getClassName()+"");
        nameTextView.setText(topStudentItem.getName()+"");
        pointsTextView.setText(topStudentItem.getPoints()+"  "+getResources().getString(R.string.label_points));
        attendancePointsTextView.setText(topStudentItem.getAttendancePoints()+"  "+getResources().getString(R.string.label_points));
        studentOfDayPointsTextView.setText(topStudentItem.getStudentOfDayPoints()+"  "+getResources().getString(R.string.label_points));
        quizPointsTextView.setText(topStudentItem.getQuizPoints()+"  "+getResources().getString(R.string.label_points));
        activitiesPointsTextView.setText(topStudentItem.getActivityPoints()+"  "+getResources().getString(R.string.label_points));
    }

}
