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
import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.topstudentsresponse.TopStudentItem;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;
import dp.school.presenter.Implementation.TopStudentPresenter;
import dp.school.views.ui.adapter.TopStudentAdapter;
import dp.school.views.ui.adapter.ViewPagerAdapter;
import dp.school.views.viewInterface.TopStudentView;


public class TopStudentFragment extends Fragment implements TopStudentView{

    View rootView;
    private JazzyRecyclerViewScrollListener jazzyScrollListener;
    @BindView(R.id.rv_top_students_collection)
    RecyclerView feedsRecycleView;
    @BindView(R.id.ll_top_students_container)
    LinearLayout llContainer;
    private TopStudentAdapter topStudentAdapter;
    private ArrayList<TopStudentItem> topStudentItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_top_students, container, false);
        ButterKnife.bind(this,rootView);
        initializeUi();
        getTopStudents();
        return rootView;
    }

    public void initializeUi(){
        topStudentItems=new ArrayList<>();
        feedsRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jazzyScrollListener = new JazzyRecyclerViewScrollListener();
        feedsRecycleView.setOnScrollListener(jazzyScrollListener);
        jazzyScrollListener.setTransitionEffect(JazzyHelper.FLIP);
    }
    public void getTopStudents(){
        BaseRequest baseRequest =new BaseRequest();
        TopStudentPresenter topStudentPresenter=new TopStudentPresenter(this);
        topStudentPresenter.getTopStudentData(baseRequest);
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onError(int code, String messageError) {
        Snackbar.make(llContainer,messageError,Snackbar.LENGTH_LONG).show();
    }


    @Override
    public void displayTopStudents(TopStudentResponse topStudentResponse) {
        if(topStudentResponse!=null) {
            topStudentItems = new ArrayList<>(topStudentResponse.getData());
            topStudentAdapter = new TopStudentAdapter(getActivity(), topStudentItems);
            feedsRecycleView.setAdapter(topStudentAdapter);
        }
    }
}
