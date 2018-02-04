package dp.school.views.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.CheckedOutputStream;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.ScheduleResponse;
import dp.school.presenter.Implementation.SchedulePresenter;
import dp.school.presenter.PresenterInterface.SchedulePresenterIml;
import dp.school.views.ui.adapter.ViewPagerAdapter;
import dp.school.views.viewInterface.ScheduleView;

/**
 * Created by Mohamed Atef on 1/29/2018.
 */

public class ScheduleFragment extends Fragment {

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
        ButterKnife.bind(this,rootView);
        setupTabLayout();
        return rootView;
    }

    public void setupTabLayout(){


        viewPagerAdapter=new ViewPagerAdapter(getActivity().getSupportFragmentManager(),true);

        viewPagerAdapter.addFragment(setTabFragment("Fri"), "Friday");
        viewPagerAdapter.addFragment(setTabFragment("Thu"), "Thursday");
        viewPagerAdapter.addFragment(setTabFragment("Wed"), "Wedenesday");
        viewPagerAdapter.addFragment(setTabFragment("Tue"), "Tuesday");
        viewPagerAdapter.addFragment(setTabFragment("Mon"), "Monday");
        viewPagerAdapter.addFragment(setTabFragment("Sun"),"Sunday");
        viewPagerAdapter.addFragment(setTabFragment("Sat"), "Saturday");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public WorkingDayFragment setTabFragment(String value){
        Bundle bundle=new Bundle();
        bundle.putString("Data",value);
        WorkingDayFragment workFragment=new WorkingDayFragment();
        workFragment.setArguments(bundle);
        return workFragment;
    }


}
