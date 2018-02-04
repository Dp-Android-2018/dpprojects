package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.response.AssignmentResponse;


/**
 * Created by PC on 27/12/2017.
 */

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ClassViewHolder> {

    ArrayList<AssignmentResponse> assignmentItems;
    private Context context;

    public AssignmentAdapter(Context context, ArrayList<AssignmentResponse> assignmentItems) {
        this.assignmentItems = assignmentItems;
        this.context=context;
    }

    @Override
    public AssignmentAdapter.ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_assignment, parent, false);
        ClassViewHolder viewHolder = new ClassViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AssignmentAdapter.ClassViewHolder holder, final int position) {
        holder.studentName.setText(assignmentItems.get(position).getStudentName());
        holder.studentAssignment.setChecked(assignmentItems.get(position).isFinished());
    }

    @Override
    public int getItemCount() {
        return assignmentItems.size();
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_assignment_student_name) TextView studentName;
        @BindView(R.id.tv_assignment_student_assignment)CheckBox studentAssignment;
        @BindView(R.id.iv_assignment_student_photo)CircularImageView studentPhoto;

        public ClassViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
