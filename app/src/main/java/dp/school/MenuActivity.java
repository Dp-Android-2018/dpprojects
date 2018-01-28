package dp.school;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yarolegovich.slidingrootnav.SlideGravity;
import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.ArrayList;

import dp.school.adapter.MenuAdapter;
import dp.school.adapter.StudentAdapter;
import dp.school.model.MenuItem;

public class MenuActivity extends AppCompatActivity {
    SlidingRootNav slide;
    RecyclerView menuList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setMenu();
    }


    public void openMenu(View view) {
        slide.openMenu(true);
    }

    private void setMenu() {
        View menuView = getLayoutInflater().inflate(R.layout.menu_left_drawer, null);
        slide = new SlidingRootNavBuilder(this)
                .withMenuOpened(true)
                .withRootViewScale(0.7f)
                .withRootViewElevation(10)
                .withRootViewYTranslation(4).withRootViewYTranslation(2).withDragDistance(170)
                .withMenuLocked(false).withMenuView(menuView)
                .withGravity(SlideGravity.RIGHT)
                .inject();

        ArrayList<MenuItem>menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_message),0));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_about_us),0));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_gallary),0));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_suggestions),0));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_contact_us),0));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_log_out),0));

        menuList = menuView.findViewById(R.id.rv_left_drawer_collection);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        MenuAdapter menuAdapter = new MenuAdapter(this,menuItems);
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(menuAdapter);
    }

}
