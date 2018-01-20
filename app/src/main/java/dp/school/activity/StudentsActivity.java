package dp.school.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.StudentAdapter;
import dp.school.response.StudentResponse;

public class StudentsActivity extends AppCompatActivity {


    RecyclerView studentsRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        ButterKnife.bind(this);

        ArrayList<StudentResponse> classItems = new ArrayList<>();
        for(int i=0; i<10000; i++){
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setClassName("Class number "+i);
            studentResponse.setName("Student Name "+(i+1));
            studentResponse.setPoints(i+3);
            classItems.add(studentResponse);
        }


        studentsRecycleView =  findViewById(R.id.rv_students_collection);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        StudentAdapter studentAdapter = new StudentAdapter(this,classItems);
        studentsRecycleView.setLayoutManager(layoutManager);
        studentsRecycleView.setAdapter(studentAdapter);


    }

}
