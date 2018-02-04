package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dp.school.R;
import dp.school.views.ui.holder.MenuViewHolder;
import dp.school.views.ui.listener.OnMenuItemClickListener;
import dp.school.model.gloabal.MenuItem;

/**
 * Created by PC on 27/12/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {

    ArrayList<MenuItem> menuItems;
    private Context context;
    private OnMenuItemClickListener onMenuItemClickListener=null;

    public MenuAdapter(Context context, ArrayList<MenuItem> menuItems) {
        this.menuItems = menuItems;
        this.context = context;
    }

    @Override
    public MenuViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        MenuViewHolder viewHolder = new MenuViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MenuViewHolder holder, final int position) {
        holder.icon.setImageResource(menuItems.get(position).getResourceId());
        holder.title.setText(menuItems.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onMenuItemClickListener!=null)
                onMenuItemClickListener.onMenuItemClicked(position);
            }
        });
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener){
        this.onMenuItemClickListener = onMenuItemClickListener;
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }


}
