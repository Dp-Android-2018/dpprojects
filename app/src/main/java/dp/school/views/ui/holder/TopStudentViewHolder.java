package dp.school.views.ui.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.FeedModel;
import dp.school.model.response.topstudentsresponse.TopStudentItem;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;

/**
 * Created by DELL on 31/01/2018.
 */

public class TopStudentViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_student_name) TextView nameTextView;
    @BindView(R.id.tv_student_class) TextView classTextView;

    private Context context;

    public TopStudentViewHolder(View view, Context context) {
        super(view);
        ButterKnife.bind(this, view);
        this.context=context;
    }

    public void bindData(TopStudentItem topStudentItem){
        nameTextView.setText(topStudentItem.getName());
        classTextView.setText(topStudentItem.getClassName());
    }
}
