package dp.school.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dp.school.R;
import dp.school.holder.StudentAttendanceHolder;

/**
 * Created by DELL on 23/01/2018.
 */

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceHolder> {

    private Context context;
    public StudentAttendanceAdapter(Context context) {
        this.context=context;
    }

    @Override
    public StudentAttendanceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_class_attendance,parent,false);
        return new StudentAttendanceHolder(v);
    }

    @Override
    public void onBindViewHolder(StudentAttendanceHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
