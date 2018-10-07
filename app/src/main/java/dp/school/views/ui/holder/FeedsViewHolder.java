package dp.school.views.ui.holder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.FeedModel;
import dp.school.views.ui.activity.FeedDetailsActivity;

/**
 * Created by DELL on 31/01/2018.
 */

public class FeedsViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_feed_title) TextView tvFeedTitle;
    @BindView(R.id.tv_feed_sub_title) TextView tvFeedSubTitle;
    @BindView(R.id.tv_feed_details) TextView details;
    @BindView(R.id.tv_feed_read_more)TextView readMore;
    @BindView(R.id.iv_feed_photo)ImageView photo;
    private Context context;

    public FeedsViewHolder(View view, Context context) {
        super(view);
        ButterKnife.bind(this, view);
        this.context=context;
    }

    public void bindData(final FeedModel feedModel){

        if(feedModel.getTitle()!=null && !feedModel.getTitle().equals(""))
            tvFeedTitle.setText(feedModel.getTitle());

        if(feedModel.getSubTitle()!=null && !feedModel.getSubTitle().equals(""))
            tvFeedSubTitle.setText(feedModel.getSubTitle());

        if(feedModel.getDetails()!=null && !feedModel.getDetails().equals(""))
            details.setText(feedModel.getDetails());

        if(feedModel.getImage()!=null && !feedModel.getImage().equals(""))
            Picasso.with(context).load(feedModel.getImage()).into(photo);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(Build.VERSION.SDK_INT>=21) {
                   photo.setTransitionName("selectedImage");
                    ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation((Activity)context, photo, photo.getTransitionName());
                    Intent i = new Intent(context, FeedDetailsActivity.class);
                    i.putExtra("FeedItem", feedModel);
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(i, activityOptionsCompat.toBundle());
                }else {
                   Intent i = new Intent(context, FeedDetailsActivity.class);
                   i.putExtra("FeedItem", feedModel);
                   i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                   context.startActivity(i);
               }

            }
        });


    }
}


