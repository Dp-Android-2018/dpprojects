package dp.school.views.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import butterknife.ButterKnife;
import dp.school.R;


public class StudentDetailsActivity extends AppCompatActivity {


    RecyclerView studentsRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_student_details);
        ButterKnife.bind(this);
    }

}
