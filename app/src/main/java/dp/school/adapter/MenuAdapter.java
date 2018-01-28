package dp.school.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.holder.MenuViewHolder;
import dp.school.model.MenuItem;
import dp.school.response.studentresponse.StudentResponse;

/**
 * Created by PC on 27/12/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    ArrayList<MenuItem> menuItems;
    private Context context;

    public MenuAdapter(Context context, ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.context=context;
    }

    @Override
    public  MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MenuViewHolder viewHolder = new MenuViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {
       //holder.icon.setText(studentItems.get(position).getUser().getName());
        holder.title.setText(menuItems.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }


}
