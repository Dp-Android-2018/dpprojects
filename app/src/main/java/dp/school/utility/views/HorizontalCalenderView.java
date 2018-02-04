package dp.school.utility.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.Calendar;
import dp.school.R;
import dp.school.views.ui.adapter.DaysAdapter;
import dp.school.views.ui.adapter.MonthsAdapter;
import dp.school.views.ui.listener.OnDayClickListener;
import dp.school.views.ui.listener.OnMonthClickListener;
import dp.school.model.gloabal.DayItem;
import dp.school.model.gloabal.MonthItem;


/**
 * Created by PC on 27/12/2017.
 */

public class HorizontalCalenderView extends LinearLayout {
    public static String[] monthsNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    ArrayList<ArrayList<DayItem>> calenderDays;
    ArrayList<MonthItem> months;
    RecyclerView monthsRecycleView;
    RecyclerView daysRecycleView;
    DayItem selectedDay = null;
    MonthItem selectedMonth = null;

    public HorizontalCalenderView(@NonNull Context context) {
        super(context);
        init(context);
    }

    public HorizontalCalenderView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(final Context context) {
        inflate(context, R.layout.view_horzontial_calender, this);
        monthsRecycleView = findViewById(R.id.rv_calender_months);
        daysRecycleView = findViewById(R.id.rv_calender_days);
        setCalenderDays();
        setCalenderMonths(context);
        MonthsAdapter monthsAdapter = new MonthsAdapter(months, context, new OnMonthClickListener() {
            @Override
            public void onMonthClickListener(int position) {

                setDaysAdapter(context, position);
            }
        });
        monthsRecycleView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        monthsRecycleView.setAdapter(monthsAdapter);

    }

    public DayItem getSelectedDay() {
        return selectedDay;
    }

    public MonthItem getSelectedMonth() {
        return selectedMonth;
    }

    private void setCalenderMonths(Context context) {
        months = new ArrayList<>();
        for (int i = 0; i < monthsNames.length; i++) {
            months.add(new MonthItem(monthsNames[i]));
        }
        setDaysAdapter(context, 0);
    }

    private void setDaysAdapter(Context context, final int position) {
        selectedMonth = months.get(position);
        selectedDay = null;
        DaysAdapter daysAdapter = new DaysAdapter(getContext(), calenderDays.get(position), new OnDayClickListener() {
            @Override
            public void onDayClickListener(int dayPosition) {
                selectedDay = calenderDays.get(position).get(dayPosition);
            }
        });
        daysRecycleView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        daysRecycleView.setAdapter(daysAdapter);
    }

    private void setCalenderDays() {
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


}
