package dp.school.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;

/**
 * Created by DELL on 22/01/2018.
 */

public class ChildrenHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_student_name)
    TextView tvStudentName;

    @BindView(R.id.tv_student_class)
    TextView tvClassNum;
    public ChildrenHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(itemView);
    }

    public TextView getTvStudentName() {
        return tvStudentName;
    }

    public TextView getTvClassNum() {
        return tvClassNum;
    }
}
