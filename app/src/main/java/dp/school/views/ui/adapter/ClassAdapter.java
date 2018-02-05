package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dp.school.R;
import dp.school.model.gloabal.ClassModel;
import dp.school.views.ui.holder.TeacherClassHoler;

/**
 * Created by PC on 27/12/2017.
 */

public class ClassAdapter extends RecyclerView.Adapter<TeacherClassHoler> {

    ArrayList<ClassModel> classItems;
    private Context context;

    public ClassAdapter(Context context,ArrayList<ClassModel> classItems) {
        this.classItems = classItems;
        this.context=context;
    }

    @Override
    public TeacherClassHoler onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_class, parent, false);
        return new TeacherClassHoler(v);
    }

    @Override
    public void onBindViewHolder(TeacherClassHoler holder, final int position) {
       holder.bindData(classItems.get(position));
    }

    @Override
    public int getItemCount() {
        return classItems.size();
    }


}
