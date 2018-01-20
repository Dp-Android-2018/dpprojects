package dp.school.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.ScheduleResponse;

/**
 * Created by PC on 27/12/2017.
 */

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ClassViewHolder> {

    ArrayList<ScheduleResponse> scheduleItems;
    private Context context;

    public ScheduleAdapter(Context context, ArrayList<ScheduleResponse> scheduleItems) {
        this.scheduleItems = scheduleItems;
        this.context=context;
    }

    @Override
    public ScheduleAdapter.ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        ClassViewHolder viewHolder = new ClassViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ScheduleAdapter.ClassViewHolder holder, final int position) {
        holder.name.setText(scheduleItems.get(position).getName());
        holder.grade.setText(scheduleItems.get(position).getGrade());
        holder.numberOfStudents.setText(scheduleItems.get(position).getName()+" "+context.getResources().getString(R.string.title_students));
        holder.time.setText(scheduleItems.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return scheduleItems.size();
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_schedule_class_name) TextView name;
        @BindView(R.id.tv_schedule_class_grade) TextView grade;
        @BindView(R.id.tv_schedule_class_number_of_students)TextView numberOfStudents;
        @BindView(R.id.tv_schedule_time)TextView time;

        public ClassViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
