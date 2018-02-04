package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import dp.school.R;
import dp.school.views.ui.listener.OnDayClickListener;
import dp.school.model.gloabal.DayItem;

/**
 * Created by PC on 27/12/2017.
 */

public class DaysAdapter extends RecyclerView.Adapter<DaysAdapter.PlanetViewHolder> {

    ArrayList<DayItem> days;
    private int currentSelected=-1;
    private Context context;
    OnDayClickListener onDayClickListener;
    public DaysAdapter(Context context ,ArrayList<DayItem> days, OnDayClickListener onDayClickListener) {
        this.days = days;
        this.context=context;
        this.onDayClickListener=onDayClickListener;
    }

    @Override
    public DaysAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_day, parent, false);
        PlanetViewHolder viewHolder = new PlanetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DaysAdapter.PlanetViewHolder holder, final int position) {
        holder.day.setText(days.get(position).getDay());
        holder.date.setText(""+days.get(position).getDate());
        if(position==currentSelected){
            holder.dayContainer.setBackgroundResource(R.drawable.round_vertical_background_blue);
            holder.day.setTextColor(context.getResources().getColor(R.color.colorWhite));
            holder.date.setTextColor(context.getResources().getColor(R.color.colorWhite));
        }else{
            holder.dayContainer.setBackground(null);
            holder.day.setTextColor(context.getResources().getColor(R.color.colorPrimary));
            holder.date.setTextColor(context.getResources().getColor(R.color.colorPrimary));
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSelected = position;
                onDayClickListener.onDayClickListener(position);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {
        protected TextView day,date;
        protected LinearLayout dayContainer;
        public PlanetViewHolder(View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.tv_item_day_day);
            date = itemView.findViewById(R.id.tv_item_day_date);
            dayContainer = itemView.findViewById(R.id.item_day_container);
        }
    }
}
