package dp.school;

import android.app.Fragment;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.eightbitlab.bottomnavigationbar.BottomBarItem;
import com.eightbitlab.bottomnavigationbar.BottomNavigationBar;
import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.adapter.MenuAdapter;
import dp.school.base.utils.FragmentUtils;
import dp.school.fragment.AboutUsFragment;
import dp.school.fragment.BaseFragment;
import dp.school.fragment.PictureGalleryFragment;
import dp.school.fragment.ScheduleFragment;
import dp.school.listener.OnMenuItemClickListener;
import dp.school.model.MenuItem;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.nb_start_tabs_container)
    BottomNavigationBar bottomNavigationBar;
    @BindView(R.id.rl_start_main_holder)
    RelativeLayout mainHolderRelativeLayout;
    SlidingRootNav slideMenuView;
    RecyclerView menuList;
    View menuView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
        FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");
        setBottomTabs();
        setBottomTabEvent();
        setMenu();

    }
    private void setBottomTabs(){
        BottomBarItem feedsTab = new BottomBarItem(R.drawable.ic_feed_off, R.string.tab_feeds);
        BottomBarItem scheduleTab = new BottomBarItem(R.drawable.ic_calender_off, R.string.tab_schedule);
        BottomBarItem topStudent = new BottomBarItem(R.drawable.ic_student_off, R.string.tab_top_student);
        BottomBarItem home = new BottomBarItem(R.drawable.ic_home_off, R.string.tab_home);
        bottomNavigationBar.addTab(home);
        bottomNavigationBar.addTab(scheduleTab);
        bottomNavigationBar.addTab(topStudent);
        bottomNavigationBar.addTab(feedsTab);


    }
    private void setBottomTabEvent(){
        bottomNavigationBar.setOnSelectListener(new BottomNavigationBar.OnSelectListener() {
            @Override
            public void onSelect(int position) {
                FragmentUtils.removeFragment(MainActivity.this);
                if(position==0)
                    FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");
                else if(position==1)
                    FragmentUtils.addFragment(MainActivity.this, new ScheduleFragment(), "");

                else if(position==2)
                    FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");

                else if(position==3)
                    FragmentUtils.addFragment(MainActivity.this, new BaseFragment(), "");


            }
        });
    }
    private ArrayList<MenuItem> getMenuItems() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
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

    private void setMenuEvents() {
        menuAdapter.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            @Override
            public void onMenuItemClicked(int position) {
                FragmentUtils.removeFragment(MainActivity.this);
                if (position == 0) {
                    // "" parameter for backstack mean that don't add me to back stack otherwise so add me with this text
                    Snackbar.make(mainHolderRelativeLayout,"EditProfile",Snackbar.LENGTH_LONG).show();
                } else if (position == 1) {
                    FragmentUtils.addFragment(MainActivity.this,new AboutUsFragment(),"");
                } else if (position == 2) {
                    Snackbar.make(mainHolderRelativeLayout,"Message",Snackbar.LENGTH_LONG).show();
                } else if (position == 3) {
                    FragmentUtils.addFragment(MainActivity.this, passDataToGallery(true),"");

                } else if (position == 4) {
                    FragmentUtils.addFragment(MainActivity.this, passDataToGallery(false),"");
                } else if (position == 5) {

                } else if (position == 6) {

                } else if (position == 7) {

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

    public android.support.v4.app.Fragment passDataToGallery(Boolean pic){
        android.support.v4.app.Fragment pictureGallery=new PictureGalleryFragment();
        Bundle b=new Bundle();
        b.putBoolean("Pic",pic);
        pictureGallery.setArguments(b);
        return pictureGallery;
    }
}
