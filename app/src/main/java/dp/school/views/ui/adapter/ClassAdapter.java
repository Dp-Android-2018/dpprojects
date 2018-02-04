package dp.school.views.ui.adapter;

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
import dp.school.model.gloabal.ClassResponse;

/**
 * Created by PC on 27/12/2017.
 */

public class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

    ArrayList<ClassResponse> classItems;
    private Context context;

    public ClassAdapter(Context context,ArrayList<ClassResponse> classItems) {
        this.classItems = classItems;
        this.context=context;
    }

    @Override
    public ClassAdapter.ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);
        ClassViewHolder viewHolder = new ClassViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ClassAdapter.ClassViewHolder holder, final int position) {
        holder.name.setText(classItems.get(position).getName());
        holder.grade.setText(classItems.get(position).getGrade());
        holder.numberOfStudents.setText(classItems.get(position).getName()+" "+context.getResources().getString(R.string.title_students));

        if(classItems.get(position).isHaveClass()){
            holder.calenderState.setBackgroundResource(R.drawable.ic_colored_calender);
        }else{
            holder.calenderState.setBackgroundResource(R.drawable.ic_calender_off );
        }
    }

    @Override
    public int getItemCount() {
        return classItems.size();
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_class_name) TextView name;
        @BindView(R.id.tv_class_grade) TextView grade;
        @BindView(R.id.tv_class_number_of_students)TextView numberOfStudents;
        @BindView(R.id.iv_class_calender_state)ImageView calenderState;

        public ClassViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
