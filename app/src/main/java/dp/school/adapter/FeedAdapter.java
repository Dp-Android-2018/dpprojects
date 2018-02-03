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
import dp.school.holder.FeedsViewHolder;
import dp.school.model.FeedModel;
import dp.school.response.FeedsResponse;


/**
 * Created by PC on 27/12/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedsViewHolder> {

    ArrayList<FeedModel> feedItems;
    private Context context;

    public FeedAdapter(Context context, ArrayList<FeedModel> feedItems) {
        this.feedItems = feedItems;
        this.context=context;
    }

    @Override
    public FeedsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
        FeedsViewHolder viewHolder = new FeedsViewHolder(v,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FeedsViewHolder holder, final int position) {
       holder.bindData(feedItems.get(position));
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }


}
