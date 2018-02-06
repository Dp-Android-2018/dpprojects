package dp.school.views.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.response.teacherresponse.TeacherScheduleResponse;
import dp.school.presenter.Implementation.SchedulePresenter;
import dp.school.presenter.PresenterInterface.SchedulePresenterIml;
import dp.school.views.ui.adapter.ViewPagerAdapter;
import dp.school.views.viewInterface.ScheduleView;

/**
 * Created by Mohamed Atef on 1/29/2018.
 */

public class ScheduleFragment extends Fragment implements ScheduleView {

    @BindView(R.id.ll_shedule_fragment_container)
    LinearLayout llContainer;
    @BindView(R.id.tl_schedule_class)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_schedule)
    ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    View rootView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_schedule_layout, container, false);
        ButterKnife.bind(this, rootView);
        SchedulePresenterIml schedulePresenterIml = new SchedulePresenter(this);
        schedulePresenterIml.getTeacherSchedule();
        return rootView;
    }

    @Override
    public void onTeacherScheduleLoaded(TeacherScheduleResponse scheduleResponse) {
        setupTabLayout(scheduleResponse);
    }


    @Override
    public void onError(int code, String messageError) {
        //Snackbar.make(containerLayout,messageError,Snackbar.LENGTH_LONG).show();
    }

    public void setupTabLayout(TeacherScheduleResponse teacherScheduleResponse) {
        viewPagerAdapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager(), true);
        viewPagerAdapter.addFragment(setTabFragment("Fri", teacherScheduleResponse), "Friday");
        viewPagerAdapter.addFragment(setTabFragment("Thu", teacherScheduleResponse), "Thursday");
        viewPagerAdapter.addFragment(setTabFragment("Wed", teacherScheduleResponse), "Wednesday");
        viewPagerAdapter.addFragment(setTabFragment("Tue", teacherScheduleResponse), "Tuesday");
        viewPagerAdapter.addFragment(setTabFragment("Mon", teacherScheduleResponse), "Monday");
        viewPagerAdapter.addFragment(setTabFragment("Sun", teacherScheduleResponse), "Sunday");
        viewPagerAdapter.addFragment(setTabFragment("Sat", teacherScheduleResponse), "Saturday");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public WorkingDayFragment setTabFragment(String value, TeacherScheduleResponse teacherScheduleResponse) {
        Gson gson = new Gson();
        String json = gson.toJson(teacherScheduleResponse);
        Bundle bundle = new Bundle();
        bundle.putString("Data", value);
        bundle.putString("details", json);
        WorkingDayFragment workFragment = new WorkingDayFragment();
        workFragment.setArguments(bundle);
        return workFragment;
    }

    @Nullable
    @Override
    public Context getContext() {
        return getActivity();
    }


}
