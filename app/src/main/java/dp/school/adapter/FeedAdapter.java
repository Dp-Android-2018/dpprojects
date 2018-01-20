package dp.school.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.response.FeedResponse;
import dp.school.response.StudentResponse;

/**
 * Created by PC on 27/12/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ClassViewHolder> {

    ArrayList<FeedResponse> feedItems;
    private Context context;

    public FeedAdapter(Context context, ArrayList<FeedResponse> feedItems) {
        this.feedItems = feedItems;
        this.context=context;
    }

    @Override
    public FeedAdapter.ClassViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        ClassViewHolder viewHolder = new ClassViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeedAdapter.ClassViewHolder holder, final int position) {
        holder.details.setText(feedItems.get(position).getDetails());
        holder.photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_feed_details) TextView details;
        @BindView(R.id.tv_feed_read_more)TextView readMore;
        @BindView(R.id.iv_feed_photo)ImageView photo;

        public ClassViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
