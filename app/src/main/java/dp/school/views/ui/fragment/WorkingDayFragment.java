package dp.school.views.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;

import dp.school.model.gloabal.SectionTimeModel;
import dp.school.model.response.teacherresponse.TeacherSchduleResponse;
import dp.school.presenter.Implementation.SchedulePresenter;
import dp.school.presenter.PresenterInterface.SchedulePresenterIml;
import dp.school.views.ui.adapter.TeacherScheduleAdapter;
import dp.school.views.viewInterface.ScheduleView;

/**
 * Created by DELL on 04/02/2018.
 */

public class WorkingDayFragment extends Fragment implements ScheduleView {
    @BindView(R.id.ll_working_day_container)
    LinearLayout llContainer;

    @BindView(R.id.rv_working_day_schedule)
    RecyclerView rvSchedule;

    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_working_day_layout,container,false);
        ButterKnife.bind(this,v);
        ///////////////////////////Connecting View To Presenter /////////////////////////////////
             SchedulePresenterIml schedulePresenterIml=new SchedulePresenter(this);
            schedulePresenterIml.getTeacherSchedule();
        /////////////////////////////////////////////////////////////////////////////////////////
        initializeUi();
        return v;
    }

    public void initializeUi(){
        rvSchedule.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
    }

    @Override
    public void onTeacherScheduleLoaded(TeacherSchduleResponse scheduleResponse) {
            notifyAdapterDataChanged (scheduleResponse);
    }


    @Override
    public void onError(int code, String messageError) {
        Snackbar.make(llContainer,messageError,Snackbar.LENGTH_LONG).show();
    }

    @Nullable
    @Override
    public Context getContext() {
        return mContext;
    }

    public void notifyAdapterDataChanged(TeacherSchduleResponse scheduleResponse){
        rvSchedule.setAdapter(new TeacherScheduleAdapter(mContext,getSchedule(scheduleResponse)));
    }

    private ArrayList<SectionTimeModel> getSchedule(TeacherSchduleResponse scheduleResponse){
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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext= context;
    }
}
