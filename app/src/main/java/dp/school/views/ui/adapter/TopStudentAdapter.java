package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dp.school.R;
import dp.school.model.gloabal.FeedModel;
import dp.school.model.response.topstudentsresponse.TopStudentItem;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;
import dp.school.views.ui.holder.FeedsViewHolder;
import dp.school.views.ui.holder.TopStudentViewHolder;


/**
 * Created by PC on 27/12/2017.
 */

public class TopStudentAdapter extends RecyclerView.Adapter<TopStudentViewHolder> {

    ArrayList<TopStudentItem> topStudentItems;
    private Context context;

    public TopStudentAdapter(Context context, ArrayList<TopStudentItem> topStudentItems) {
        this.topStudentItems = topStudentItems;
        this.context=context;
    }

    @Override
    public TopStudentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student, parent, false);
        TopStudentViewHolder viewHolder = new TopStudentViewHolder(v,context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TopStudentViewHolder holder, final int position) {
       holder.bindData(topStudentItems.get(position));
    }

    @Override
    public int getItemCount() {
        return topStudentItems.size();
    }


}
