package dp.school.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import dp.school.R;
import dp.school.holder.ParentYearsHolder;
import dp.school.holder.PaymentChildrensHolder;
import dp.school.model.Children;

/**
 * Created by DELL on 22/01/2018.
 */

public class PaymentAdapter extends ExpandableRecyclerViewAdapter<ParentYearsHolder,PaymentChildrensHolder> {

    public PaymentAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public ParentYearsHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_parent_expandable_recycler,parent,false);
        return new ParentYearsHolder(v);
    }

    @Override
    public PaymentChildrensHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_child_expandable,parent,false);
        return new PaymentChildrensHolder(v);
    }

    @Override
    public void onBindChildViewHolder(PaymentChildrensHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        Children children= (Children) group.getItems().get(childIndex);
        holder.setTvPaymentData(children);

    }

    @Override
    public void onBindGroupViewHolder(ParentYearsHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setTvYear(group);

    }
}
