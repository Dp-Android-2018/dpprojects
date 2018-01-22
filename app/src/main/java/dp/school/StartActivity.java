package dp.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.base.utils.FragmentUtils;

public class StartActivity extends AppCompatActivity {
    @BindView(R.id.nb_start_tabs_container)
    BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        FragmentUtils.addFragment(StartActivity.this,new TestFragment(),"");

        BottomBarItem feedsTab = new BottomBarItem(R.drawable.ic_feed_off, R.string.tab_feeds);
        BottomBarItem scheduleTab = new BottomBarItem(R.drawable.ic_calender_off, R.string.tab_schedule);
        BottomBarItem topStudent = new BottomBarItem(R.drawable.ic_student_off, R.string.tab_top_student);
        BottomBarItem home = new BottomBarItem(R.drawable.ic_home_off, R.string.tab_home);
        bottomNavigationBar.addTab(home);
        bottomNavigationBar.addTab(scheduleTab);
        bottomNavigationBar.addTab(topStudent);
        bottomNavigationBar.addTab(feedsTab);

    }
}
