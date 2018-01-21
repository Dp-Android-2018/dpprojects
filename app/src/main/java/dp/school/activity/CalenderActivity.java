package dp.school.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.ScheduleAdapter;
import dp.school.base.views.HorizontalCalenderView;
import dp.school.model.DayItem;
import dp.school.adapter.DaysAdapter;
import dp.school.model.MonthItem;
import dp.school.adapter.MonthsAdapter;
import dp.school.listener.OnMonthClickListener;
import dp.school.model.ScheduleResponse;

public class CalenderActivity extends AppCompatActivity {


    CoordinatorLayout mRootLayout;
    RecyclerView classesRecycleView;
    HorizontalCalenderView horizontalCalenderView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        ButterKnife.bind(this);
         horizontalCalenderView = (HorizontalCalenderView)findViewById(R.id.hcv_calender_mycalender);



        ArrayList<ScheduleResponse>classItems = new ArrayList<>();
        for(int i=0; i<10; i++){
            ScheduleResponse schaduleResponse = new ScheduleResponse();
            schaduleResponse.setGrade("First grade");
            schaduleResponse.setName("Class name #"+(i+1));
            schaduleResponse.setNumberOfStudent(23+i+1*3);
            schaduleResponse.setTime("12:32");

            classItems.add(schaduleResponse);
        }

        classesRecycleView =  findViewById(R.id.rv_calender_schdule);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        ScheduleAdapter  scheduleAdapter = new ScheduleAdapter(this,classItems);
        classesRecycleView.setLayoutManager(layoutManager);
        classesRecycleView.setAdapter(scheduleAdapter);


    }




    public void go(){
        if(horizontalCalenderView.getSelectedDay()!=null)
        Toast.makeText(this, horizontalCalenderView.getSelectedMonth().getMonth()+" "+horizontalCalenderView.getSelectedDay().getDay()+" "+horizontalCalenderView.getSelectedDay().getDate(), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "liked it", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
