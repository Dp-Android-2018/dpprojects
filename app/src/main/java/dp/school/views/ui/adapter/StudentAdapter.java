package dp.school.views.ui.adapter;

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
import dp.school.model.response.studentresponse.StudentResponse;

/**
 * Created by PC on 27/12/2017.
 */

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ClassViewHolder> {

    ArrayList<StudentResponse> studentItems;
    private Context context;

    public StudentAdapter(Context context, ArrayList<StudentResponse> studentItems) {
        this.studentItems = studentItems;
        this.context=context;
    }

    @Override
    public StudentAdapter.ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        ClassViewHolder viewHolder = new ClassViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentAdapter.ClassViewHolder holder, final int position) {
        holder.name.setText(studentItems.get(position).getUser().getName());
        holder.class_.setText(studentItems.get(position).getUser().getName());
        holder.points.setText(studentItems.get(position).getUser().getId()+" "+context.getResources().getString(R.string.points));
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return studentItems.size();
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_student_name) TextView name;
        @BindView(R.id.tv_student_class) TextView class_;
        @BindView(R.id.tv_student_points)TextView points;
        @BindView(R.id.iv_student_photo)CircularImageView photo;

        public ClassViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
