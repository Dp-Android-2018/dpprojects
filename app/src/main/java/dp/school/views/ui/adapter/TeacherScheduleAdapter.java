package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dp.school.R;
import dp.school.model.gloabal.SectionTimeModel;
import dp.school.views.ui.holder.TeacherSheduleHolder;

/**
 * Created by DELL on 04/02/2018.
 */

public class TeacherScheduleAdapter extends RecyclerView.Adapter<TeacherSheduleHolder> {

    private Context context;
    private ArrayList<SectionTimeModel>data;
    public TeacherScheduleAdapter(Context context, ArrayList<SectionTimeModel>data) {
        this.context=context;
        this.data=data;
    }

    @Override
    public TeacherSheduleHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule,parent,false);
        return new TeacherSheduleHolder(view);
    }

    @Override
    public void onBindViewHolder(TeacherSheduleHolder holder, int position) {
        holder.BindData(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }
}
