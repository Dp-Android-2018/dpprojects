package dp.school.views.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.views.ui.adapter.ViewPagerAdapter;
import dp.school.views.ui.fragment.StudentAttendanceFragment;
import dp.school.views.ui.fragment.StudentQuizFragment;

/**
 * Created by DELL on 20/01/2018.
 */

public class ClassActivity extends AppCompatActivity {

        @BindView(R.id.tl_class)
        TabLayout tabLayout;

        @BindView(R.id.viewpager)
        ViewPager viewPager;
        private LinearLayout linearLayoutOne,linearLayout2,linearLayout3;
        private TextView tvTab1,tvTab2,tvTab3;
    private int prev=0;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_layout);
        ButterKnife.bind(this);
         viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager(),true);
        viewPagerAdapter.addFragment(new StudentAttendanceFragment(),"ONE");
        viewPagerAdapter.addFragment(new StudentQuizFragment(), "TWO");
        viewPagerAdapter.addFragment(new StudentQuizFragment(), "THREE");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

       View headerView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.tab1_layout, null, false);

        View headerView2 = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.tab2_layout, null, false);

        View headerView3 = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(R.layout.tab3_layout, null, false);
         linearLayoutOne = (LinearLayout) headerView.findViewById(R.id.ll1);
         tvTab1=(TextView)headerView.findViewById(R.id.tvTab1);
         linearLayout2 = (LinearLayout) headerView2.findViewById(R.id.ll1);
        tvTab2=(TextView)headerView2.findViewById(R.id.tvTab2);
         linearLayout3 = (LinearLayout) headerView3.findViewById(R.id.ll1);
        tvTab3=(TextView)headerView3.findViewById(R.id.tvTab3);

        tabLayout.getTabAt(0).setCustomView(linearLayoutOne);
        tabLayout.getTabAt(1).setCustomView(linearLayout2);
        tabLayout.getTabAt(2).setCustomView(linearLayout3);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                    if(prev==0)
                        tvTab1.setTextColor(getResources().getColor(R.color.colorLightBlue));

                    else if(prev==1)
                        tvTab2.setTextColor(getResources().getColor(R.color.colorLightBlue));

                    else if(prev==2)
                        tvTab3.setTextColor(getResources().getColor(R.color.colorLightBlue));



                    if(tab.getPosition()==0)
                        tvTab1.setTextColor(getResources().getColor(R.color.colorWhite));

                else if(tab.getPosition()==1)
                    tvTab2.setTextColor(getResources().getColor(R.color.colorWhite));

                else if(tab.getPosition()==2)
                    tvTab3.setTextColor(getResources().getColor(R.color.colorWhite));

                prev=tab.getPosition();


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }


}
