package dp.school.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.FeedAdapter;
import dp.school.model.FeedModel;
import dp.school.presenter.Implementation.FeedsPresenter;
import dp.school.presenter.PresenterInterface.FeedsPresenterIml;
import dp.school.request.BaseRequest;
import dp.school.response.FeedsResponse;
import dp.school.views.FeedsView;

public class FeedsActivity extends AppCompatActivity implements FeedsView{

    private JazzyRecyclerViewScrollListener jazzyScrollListener;

    @BindView(R.id.rv_feeds_collection)
    RecyclerView studentsRecycleView;

    @BindView(R.id.ll_container)
    LinearLayout llContainer;

    private  FeedAdapter feedAdapter;
    private ArrayList<FeedModel>feedItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        ButterKnife.bind(this);
        initializeUi();
        getFeedsData();

    }
    public void initializeUi(){
        feedItems=new ArrayList<>();

        studentsRecycleView.setLayoutManager(new LinearLayoutManager(this));
        jazzyScrollListener = new JazzyRecyclerViewScrollListener();
        studentsRecycleView.setOnScrollListener(jazzyScrollListener);
        jazzyScrollListener.setTransitionEffect(JazzyHelper.FLIP);
    }
    public void getFeedsData(){
        BaseRequest baseRequest =new BaseRequest();
        baseRequest.setApiToken("p8atgfTxGRRZF7ic5VszLprlMHjWc720UVnOHnDxnTnnSxK6tZe4hMaijvMhgxrC");
        FeedsPresenterIml feedsPresenterIml=new FeedsPresenter(this);
        feedsPresenterIml.getFeedsData(baseRequest);
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onError(int code, String messageError) {
        Snackbar.make(llContainer,messageError,Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onFeedsDataLoaded(FeedsResponse feedsResponse) {
        feedItems=feedsResponse.getFeeds().getData();
        feedAdapter=new FeedAdapter(this,feedItems);
        studentsRecycleView.setAdapter(feedAdapter);
    }
}
