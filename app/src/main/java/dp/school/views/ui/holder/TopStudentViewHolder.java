package dp.school.views.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.FeedModel;
import dp.school.model.response.topstudentsresponse.TopStudentItem;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;
import dp.school.views.ui.activity.TopStudentDetailsActivity;

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
        if(Build.VERSION.SDK_INT>=21) {
            float maxWidthOffset = 2f * context.getResources().getDisplayMetrics().widthPixels;
            float maxHeightOffset = 2f * context.getResources().getDisplayMetrics().heightPixels;
            Interpolator interpolator =
                    AnimationUtils.loadInterpolator(context, android.R.interpolator.linear_out_slow_in);
            Random random = new Random();
            //  View view = root.getChildAt(i);
            view.setVisibility(View.VISIBLE);
            view.setAlpha(0.85f);
            float xOffset = random.nextFloat() * maxWidthOffset;
            if (random.nextBoolean()) {
                xOffset *= -1;
            }
            view.setTranslationX(xOffset);
            float yOffset = random.nextFloat() * maxHeightOffset;
            if (random.nextBoolean()) {
                yOffset *= -1;
            }
            view.setTranslationY(yOffset);

            // now animate them back into their natural position
            view.animate()
                    .translationY(0f)
                    .translationX(0f)
                    .alpha(1f)
                    .setInterpolator(interpolator)
                    .setDuration(1000)
                    .start();
        }else {
            view.setVisibility(View.VISIBLE);
        }

    }

    public void bindData(final TopStudentItem topStudentItem){
        nameTextView.setText(topStudentItem.getName());
        classTextView.setText(topStudentItem.getClassName());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TopStudentDetailsActivity.class);
                intent.putExtra("topStudentDetails",new Gson().toJson(topStudentItem));
                context.startActivity(intent);
            }
        });
    }
}
