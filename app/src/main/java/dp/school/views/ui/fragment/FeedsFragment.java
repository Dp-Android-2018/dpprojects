package dp.school.views.ui.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
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
import dp.school.model.gloabal.FeedModel;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.FeedsResponse;
import dp.school.presenter.Implementation.FeedsPresenter;
import dp.school.presenter.PresenterInterface.FeedsPresenterIml;
import dp.school.views.ui.adapter.FeedAdapter;
import dp.school.views.viewInterface.FeedsView;

/**
 * Created by Mohamed Atef on 2/4/2018.
 */

public class FeedsFragment extends Fragment implements FeedsView {

    View rootView;
    private JazzyRecyclerViewScrollListener jazzyScrollListener;
    @BindView(R.id.rv_feeds_collection)
    RecyclerView feedsRecycleView;
    @BindView(R.id.ll_feeds_container)
    LinearLayout llContainer;
    private  FeedAdapter feedAdapter;
    private ArrayList<FeedModel>feedItems;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.activity_feeds, container, false);
        ButterKnife.bind(this,rootView);
        initializeUi();
        getFeedsData();
        return rootView;
    }

    public void initializeUi(){
        feedItems=new ArrayList<>();
        feedsRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        jazzyScrollListener = new JazzyRecyclerViewScrollListener();
        feedsRecycleView.setOnScrollListener(jazzyScrollListener);
        jazzyScrollListener.setTransitionEffect(JazzyHelper.FLIP);
    }
    public void getFeedsData(){
        BaseRequest baseRequest =new BaseRequest();
        FeedsPresenterIml feedsPresenterIml=new FeedsPresenter(this);
        feedsPresenterIml.getFeedsData(baseRequest);
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
    public void onFeedsDataLoaded(FeedsResponse feedsResponse) {
        if(feedsResponse!=null) {
            feedItems = feedsResponse.getData();
            feedAdapter = new FeedAdapter(getActivity(), feedItems);
            feedsRecycleView.setAdapter(feedAdapter);
        }
    }
}
