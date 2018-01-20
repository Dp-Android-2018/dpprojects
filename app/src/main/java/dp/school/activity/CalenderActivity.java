package dp.school.activity;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.ScheduleAdapter;
import dp.school.model.DayItem;
import dp.school.adapter.DaysAdapter;
import dp.school.model.MonthItem;
import dp.school.adapter.MonthsAdapter;
import dp.school.listener.OnMonthClickListener;
import dp.school.model.ScheduleResponse;

public class CalenderActivity extends AppCompatActivity {

    public static String[] monthsNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    ArrayList<ArrayList<DayItem>> calenderDays;
    ArrayList<MonthItem> months;
    @BindView(R.id.rv_calender_months)
    RecyclerView monthsRecycleView;
    @BindView(R.id.rv_calender_days)
    RecyclerView daysRecycleView;
    CoordinatorLayout mRootLayout;
    RecyclerView classesRecycleView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        ButterKnife.bind(this);
        setCalenderDays();
        setCalenderMonths();

        MonthsAdapter monthsAdapter = new MonthsAdapter(months, this, new OnMonthClickListener() {
            @Override
            public void onMonthClickListener(int position) {
                DaysAdapter daysAdapter = new DaysAdapter(calenderDays.get(position), CalenderActivity.this);
                daysRecycleView.setLayoutManager(new LinearLayoutManager(CalenderActivity.this, LinearLayoutManager.HORIZONTAL, false));
                daysRecycleView.setAdapter(daysAdapter);
            }
        });
        monthsRecycleView.setLayoutManager(new LinearLayoutManager(CalenderActivity.this, LinearLayoutManager.HORIZONTAL, false));
        monthsRecycleView.setAdapter(monthsAdapter);



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


    private void setCalenderMonths(){
        months = new ArrayList<>();
        for (int i = 0; i < monthsNames.length; i++) {
            months.add(new MonthItem(monthsNames[i]));
        }
        DaysAdapter daysAdapter = new DaysAdapter(calenderDays.get(0), CalenderActivity.this);
        daysRecycleView.setLayoutManager(new LinearLayoutManager(CalenderActivity.this, LinearLayoutManager.HORIZONTAL, false));
        daysRecycleView.setAdapter(daysAdapter);
    }

    private void setCalenderDays(){
        calenderDays = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            Calendar cal = Calendar.getInstance();
            cal.set(Calendar.YEAR, cal.get(Calendar.YEAR));
            cal.set(Calendar.MONTH, i);
            cal.set(Calendar.DAY_OF_MONTH, 1);
            int myMonth = cal.get(Calendar.MONTH);
            ArrayList<DayItem> days = new ArrayList<>();

            while (myMonth == cal.get(Calendar.MONTH)) {
                String dayString = "";
                int dayDate = cal.get(Calendar.DAY_OF_WEEK);
                switch (dayDate) {
                    case 1:
                        dayString = "Su";
                        break;
                    case 2:
                        dayString = "Mo";
                        break;
                    case 3:
                        dayString = "Tu";
                        break;
                    case 4:
                        dayString = "We";
                        break;
                    case 5:
                        dayString = "Th";
                        break;
                    case 6:
                        dayString = "Fr";
                        break;
                    case 7:
                        dayString = "Sa";
                }
                days.add(new DayItem(dayString, cal.get(Calendar.DAY_OF_MONTH)));
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
            calenderDays.add(days);
        }
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
