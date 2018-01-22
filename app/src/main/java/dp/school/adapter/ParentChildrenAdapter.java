package dp.school.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

import dp.school.R;
import dp.school.holder.ChildrenHolder;

/**
 * Created by DELL on 22/01/2018.
 */

public class ParentChildrenAdapter extends RecyclerView.Adapter<ChildrenHolder> {
    private Context context;
    private ArrayList<String>children;

    public ParentChildrenAdapter(Context context, ArrayList<String>children) {
        this.context=context;
        this.children=children;
    }

    @Override
    public ChildrenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activity,parent,false);
        return new ChildrenHolder(v);
    }

    @Override
    public void onBindViewHolder(ChildrenHolder holder, int position) {

    }



    @Override
    public int getItemCount() {
        return children.size();
    }
}
