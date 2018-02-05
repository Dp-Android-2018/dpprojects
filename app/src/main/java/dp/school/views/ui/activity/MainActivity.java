package dp.school.views.ui.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.MenuItem;
import dp.school.utility.utils.FragmentUtils;
import dp.school.utility.utils.SharedPreferenceUtils;
import dp.school.views.ui.adapter.MenuAdapter;
import dp.school.views.ui.fragment.AboutUsFragment;
import dp.school.views.ui.fragment.BaseFragment;
import dp.school.views.ui.fragment.ContactUsFragment;
import dp.school.views.ui.fragment.FeedsFragment;
import dp.school.views.ui.fragment.PictureGalleryFragment;
import dp.school.views.ui.fragment.ScheduleFragment;
import dp.school.views.ui.fragment.SuggestionFragment;
import dp.school.views.ui.fragment.TopStudentFragment;
import dp.school.views.ui.fragment.TopStudentFragmentTabsContainer;
import dp.school.views.ui.listener.OnMenuItemClickListener;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.nb_main_tabs_container)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.rl_start_main_holder)
    RelativeLayout mainHolderRelativeLayout;
    @BindView(R.id.rl_main_header)
    RelativeLayout headerLayout;
    @BindView(R.id.fl_menu_container)
    FrameLayout containerLayout;
    @BindView(R.id.tv_main_title)
    TextView titleText;
    @BindView(R.id.iv_main_menu)
    ImageView menuImageView;
    SlidingRootNav slideMenuView;
    RecyclerView menuList;
    View menuView;
    ArrayList<MenuItem> menuItems;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");
        setBottomTabs();
        setBottomTabEvent();
        setMenu();
        setEvents();
    }

    private void setBottomTabs() {
        BottomBarItem feedsTab = new BottomBarItem(R.drawable.ic_feed_off, R.string.tab_feeds);
        BottomBarItem scheduleTab = new BottomBarItem(R.drawable.ic_calender_off, R.string.tab_schedule);
        BottomBarItem topStudent = new BottomBarItem(R.drawable.ic_student_off, R.string.tab_top_student);
        BottomBarItem home = new BottomBarItem(R.drawable.ic_home_off, R.string.tab_home);
        bottomNavigationBar.addTab(home);
        bottomNavigationBar.addTab(scheduleTab);
        bottomNavigationBar.addTab(topStudent);
        bottomNavigationBar.addTab(feedsTab);
    }

    private void setBottomTabEvent() {
        bottomNavigationBar.setOnSelectListener(new BottomNavigationBar.OnSelectListener() {
            @Override
            public void onSelect(int position) {
                FragmentUtils.removeFragment(MainActivity.this);
                String title="";

                if (position == 0) {
                    FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");
                }
                else if (position == 1) {
                    FragmentUtils.addFragment(MainActivity.this, new ScheduleFragment(), "");
                    title = getResources().getString(R.string.tab_schedule);
                }
                else if (position == 2) {
                    FragmentUtils.addFragment(MainActivity.this, new TopStudentFragment(), "");
                    title = getResources().getString(R.string.tab_schedule);
                }
                else if (position == 3) {
                    FragmentUtils.addFragment(MainActivity.this, new FeedsFragment(), "");
                    title = getResources().getString(R.string.tab_feeds);
                }
                setHeaderTitleConfigurations(position,title);
            }
        });
    }

    private ArrayList<MenuItem> getMenuItems() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_home), R.drawable.ic_home_off));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_profile), R.drawable.ic_menu_profile));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_about_us), R.drawable.ic_menu_about_us));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_message), R.drawable.ic_menu_message));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_gallary), R.drawable.ic_menu_gallary));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_video), R.drawable.ic_menu_gallary));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_suggestions), R.drawable.ic_menu_suggestion));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_contact_us), R.drawable.ic_menu_contact_us));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_log_out), R.drawable.ic_menu_log_out));
        return menuItems;
    }

    MenuAdapter menuAdapter;

    private void setUpMenu() {
        menuList = menuView.findViewById(R.id.rv_left_drawer_collection);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        menuAdapter = new MenuAdapter(this, getMenuItems());
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(menuAdapter);
        setMenuEvents();
    }

    private void setHeaderTitleConfigurations(int position , String title) {

        if (position != 0) {
            titleText.setVisibility(View.VISIBLE);
            headerLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.BELOW, R.id.rl_main_header);
            containerLayout.setLayoutParams(params);
        } else {
            titleText.setVisibility(View.GONE);
            headerLayout.setBackgroundColor(getResources().getColor(R.color.transparent));
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            containerLayout.setLayoutParams(params);
        }
        titleText.setText(title);

    }

    private void setMenuEvents() {
        menuAdapter.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                FragmentUtils.removeFragment(MainActivity.this);
                setHeaderTitleConfigurations(position,menuItems.get(position).getTitle());
                if (position == 0) {
                    FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");
                } else if (position == 1) {
                } else if (position == 2) {
                    FragmentUtils.addFragment(MainActivity.this, new AboutUsFragment(), "");
                } else if (position == 3) {
                } else if (position == 4) {
                    FragmentUtils.addFragment(MainActivity.this, passDataToGallery(true), "");
                } else if (position == 5) {
                    FragmentUtils.addFragment(MainActivity.this, passDataToGallery(false), "");
                } else if (position == 6) {
                    FragmentUtils.addFragment(MainActivity.this, new SuggestionFragment(), "");
                } else if (position == 7) {
                    FragmentUtils.addFragment(MainActivity.this, new ContactUsFragment(), "");
                } else if (position == 8) {
                    SharedPreferenceUtils.clearSharedPreference();
                    Intent i=new Intent(getApplicationContext(),StartActivity.class);
                    startActivity(i);
                    finishAffinity();
                }
                slideMenuView.closeMenu(true);
            }
        });
    }

    private void setMenu() {
        menuView = getLayoutInflater().inflate(R.layout.menu_left_drawer, null);
        slideMenuView = new SlidingRootNavBuilder(this)
                .withMenuOpened(true)
                .withRootViewScale(0.7f)
                .withRootViewElevation(10)
                .withRootViewYTranslation(4).withRootViewYTranslation(2).withDragDistance(170)
                .withMenuLocked(false).withMenuView(menuView)
                .withGravity(SlideGravity.LEFT)
                .inject();
        slideMenuView.closeMenu(false);
        setUpMenu();
    }



    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, getResources().getString(R.string.msg_double_click), Toast.LENGTH_SHORT).show();
        setHeaderTitleConfigurations(0,menuItems.get(0).getTitle());
        FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

    }

    public android.support.v4.app.Fragment passDataToGallery(Boolean pic){
        android.support.v4.app.Fragment pictureGallery=new PictureGalleryFragment();
        Bundle b=new Bundle();
        b.putBoolean("Pic",pic);
        pictureGallery.setArguments(b);
        return pictureGallery;
    }

    private void setEvents(){
        menuImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(slideMenuView.isMenuOpened()){
                    slideMenuView.closeMenu(true);
                }else {
                    slideMenuView.openMenu(true);
                }
            }
        });
    }
}
