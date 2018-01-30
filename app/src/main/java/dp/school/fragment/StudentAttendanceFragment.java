package dp.school.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.StudentAttendanceAdapter;

/**
 * Created by DELL on 23/01/2018.
 */

public class StudentAttendanceFragment extends Fragment {

    @BindView(R.id.rv_students)
    RecyclerView rvStudents;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_class_students_layout,container,false);
        ButterKnife.bind(this,v);
        rvStudents.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext(), LinearLayout.HORIZONTAL,false));
        rvStudents.setAdapter(new StudentAttendanceAdapter(getActivity()));
        return v;
    }
}
