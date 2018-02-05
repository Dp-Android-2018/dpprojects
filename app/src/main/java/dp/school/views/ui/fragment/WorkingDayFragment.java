package dp.school.views.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.google.gson.Gson;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.SectionTimeModel;
import dp.school.model.response.teacherresponse.TeacherScheduleResponse;
import dp.school.views.ui.adapter.TeacherScheduleAdapter;

/**
 * Created by DELL on 04/02/2018.
 */

public class WorkingDayFragment extends Fragment{
    @BindView(R.id.ll_working_day_container)
    LinearLayout containerLayout;
    @BindView(R.id.rv_working_day_schedule)
    RecyclerView scheduleRecycleView;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_working_day_layout,container,false);
        ButterKnife.bind(this,v);
        System.out.println("xyz");
        initializeUi();
        notifyAdapterDataChanged(new Gson().fromJson(getArguments().getString("details"),TeacherScheduleResponse.class));
        return v;
    }

    public void initializeUi(){
        scheduleRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public void notifyAdapterDataChanged(TeacherScheduleResponse scheduleResponse){
        scheduleRecycleView.setAdapter(new TeacherScheduleAdapter(getActivity(),getSchedule(scheduleResponse)));
    }

    private ArrayList<SectionTimeModel> getSchedule(TeacherScheduleResponse scheduleResponse){
        ArrayList<SectionTimeModel>data=new ArrayList<>();
        if(getArguments()!=null) {
            switch (getArguments().getString("Data")) {
                case "Sun":
                    if (scheduleResponse.getData().getSun() != null)
                        data = scheduleResponse.getData().getSun();
                    break;
                case "Mon":
                    if (scheduleResponse.getData().getMon() != null)
                        data = scheduleResponse.getData().getMon();
                    break;
                case "Tue":
                    if (scheduleResponse.getData().getTue() != null)
                        data = scheduleResponse.getData().getTue();
                    break;
                case "Wed":
                    if (scheduleResponse.getData().getWed() != null)
                        data = scheduleResponse.getData().getWed();
                    break;
                case "Thu":
                    if (scheduleResponse.getData().getThu() != null)
                        data = scheduleResponse.getData().getThu();
                    break;
                case "Fri":
                    if (scheduleResponse.getData().getFri() != null)
                        data = scheduleResponse.getData().getFri();
                    break;
                case "Sat":
                    if (scheduleResponse.getData().getSat() != null)
                        data = scheduleResponse.getData().getSat();
                    break;
                default:
                    System.out.println("Error");

            }
        }
            return  data;
    }


}
