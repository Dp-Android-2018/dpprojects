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
import dp.school.model.MenuItem;

public class MenuActivity extends AppCompatActivity {
    SlidingRootNav slide;
    RecyclerView menuList;
    View menuView;

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
        menuView = getLayoutInflater().inflate(R.layout.menu_left_drawer, null);
        slide = new SlidingRootNavBuilder(this)
                .withMenuOpened(true)
                .withRootViewScale(0.7f)
                .withRootViewElevation(10)
                .withRootViewYTranslation(4).withRootViewYTranslation(2).withDragDistance(170)
                .withMenuLocked(false).withMenuView(menuView)
                .withGravity(SlideGravity.RIGHT)
                .inject();
        slide.closeMenu(false);
        setUpMenu();
    }


    private ArrayList<MenuItem> getMenuItems() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_profile), R.drawable.ic_menu_profile));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_about_us), R.drawable.ic_menu_about_us));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_message), R.drawable.ic_menu_message));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_gallary), R.drawable.ic_menu_gallary));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_video),R.drawable.ic_menu_gallary));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_suggestions), R.drawable.ic_menu_suggestion));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_contact_us), R.drawable.ic_menu_contact_us));
        menuItems.add(new MenuItem(getResources().getString(R.string.menu_log_out), R.drawable.ic_menu_log_out));
        return menuItems;
    }

    private void setUpMenu() {
        menuList = menuView.findViewById(R.id.rv_left_drawer_collection);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        MenuAdapter menuAdapter = new MenuAdapter(this, getMenuItems());
        menuList.setLayoutManager(layoutManager);
        menuList.setAdapter(menuAdapter);
    }
}
