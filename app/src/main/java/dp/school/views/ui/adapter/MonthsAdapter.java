package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import dp.school.R;
import dp.school.views.ui.listener.OnMonthClickListener;
import dp.school.model.gloabal.MonthItem;

/**
 * Created by PC on 27/12/2017.
 */

public class MonthsAdapter extends RecyclerView.Adapter<MonthsAdapter.PlanetViewHolder> {

    private int currentSelected=0;
    private ArrayList<MonthItem> months;
    private OnMonthClickListener onMonthClickListener;
    private Context context;
    public MonthsAdapter(ArrayList<MonthItem> months, Context context,  OnMonthClickListener onMonthClickListener) {
        this.months = months;
        this.onMonthClickListener = onMonthClickListener;
        this.context=context;
    }

    @Override
    public MonthsAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_month, parent, false);
        PlanetViewHolder viewHolder = new PlanetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MonthsAdapter.PlanetViewHolder holder, final int position) {
        holder.month.setText(months.get(position).getMonth());
        if(position==currentSelected){
            holder.month.setTextColor(context.getResources().getColor(R.color.colorWhite));
        }else{
            holder.month.setTextColor(context.getResources().getColor(R.color.colorBlack));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onMonthClickListener.onMonthClickListener(position);
                currentSelected=position;
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return months.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {
        protected TextView month;

        public PlanetViewHolder(View itemView) {
            super(itemView);
            month = itemView.findViewById(R.id.tv_item_month_month);
        }
    }
}
