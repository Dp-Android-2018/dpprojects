package dp.school.views.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.topstudentsresponse.TopStudentItem;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;
import dp.school.presenter.Implementation.TopStudentPresenter;
import dp.school.views.ui.adapter.TopStudentAdapter;
import dp.school.views.ui.adapter.ViewPagerAdapter;
import dp.school.views.viewInterface.TopStudentView;


public class TopStudentFragmentTabsContainer extends Fragment {
    View rootView;
    @BindView(R.id.tl_top_students_tabs)
    TabLayout topStudentsTabsTabLayout;
    @BindView(R.id.vp_top_students_pager)
    ViewPager topStudentsViewPager;
    private ViewPagerAdapter viewPagerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_top_students_tabs_container, container, false);
        ButterKnife.bind(this,rootView);
        setPageViewer();
        return rootView;
    }

    private void setPageViewer(){
        viewPagerAdapter=new ViewPagerAdapter(getActivity().getSupportFragmentManager(),true);
        viewPagerAdapter.addFragment(new TopStudentFragment(),"ONE");
        viewPagerAdapter.addFragment(new TopStudentFragment(), "TWO");
        topStudentsViewPager.setAdapter(viewPagerAdapter);
        topStudentsTabsTabLayout.setupWithViewPager(topStudentsViewPager);


    }
}
