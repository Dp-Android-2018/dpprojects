package dp.school.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.AssignmentAdapter;
import dp.school.adapter.StudentAdapter;
import dp.school.response.AssignmentResponse;
import dp.school.response.StudentResponse;

public class AssignmentsActivity extends AppCompatActivity {


    RecyclerView studentsRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_assignment_details);
        ButterKnife.bind(this);

        /*ArrayList<AssignmentResponse> classItems = new ArrayList<>();
        for(int i=0; i<10000; i++){
            AssignmentResponse assignmentResponse = new AssignmentResponse();
            assignmentResponse.setStudentName("Student Name "+i);
            assignmentResponse.setFinished((i&1)==0);
            classItems.add(assignmentResponse);
        }


        studentsRecycleView =  findViewById(R.id.rv_students_collection);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        AssignmentAdapter assignmentAdapter = new AssignmentAdapter(this,classItems);
        studentsRecycleView.setLayoutManager(layoutManager);
        studentsRecycleView.setAdapter(assignmentAdapter);
        */

    }

}
