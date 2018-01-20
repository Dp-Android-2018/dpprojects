package dp.school.base.views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import dp.school.R;
import dp.school.base.listner.OnLoadMoreListener;


/**
 * Created by PC on 27/12/2017.
 */

public class CustomRecycleView extends LinearLayout {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SwipeRefreshLayout swipeRefreshLayout;

    public CustomRecycleView(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomRecycleView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.view_custom_recycle, this);
        recyclerView = findViewById(R.id.rv_custom_recycle_collection);
        swipeRefreshLayout = findViewById(R.id.srl_custom_recycle_refresher);
    }

    public void setAdapter(RecyclerView.Adapter recycleAdapter, LinearLayoutManager layoutManager) {
        this.layoutManager = layoutManager;
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recycleAdapter);
    }

    private boolean loading = true;
    int pastVisibleItems, visibleItemCount, totalItemCount;

    public void setLoadMoreLisetner(final OnLoadMoreListener onLoadMoreListener) {

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    visibleItemCount = layoutManager.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    pastVisibleItems = layoutManager.findFirstVisibleItemPosition();
                    if (loading) {
                        if ((visibleItemCount + pastVisibleItems) >= totalItemCount) {
                            onLoadMoreListener.onLoadMore();
                        }
                    }
                }
            }
        });
    }


    public SwipeRefreshLayout getSwipeRefreshLayout(){
        return swipeRefreshLayout;
    }
    public void stopRefreshing(){
                swipeRefreshLayout.setRefreshing(false);
    }

    public void stopLoading(){
        loading =false;
    }


}
