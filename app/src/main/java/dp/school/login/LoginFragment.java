package dp.school.login;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import dp.school.R;
import dp.school.adapter.LoginAdapter;
import dp.school.base.listner.OnLoadMoreListener;
import dp.school.base.views.CustomRecycleView;

public class LoginFragment extends Fragment implements LoginView {
    CustomRecycleView customRecycleView;
    View rootView;
    ProgressDialog progress;
    ArrayList<String> planetList;
    LoginAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_login, container, false);




        progress = new ProgressDialog(getActivity());
        progress.setMessage("loading");
        progress.setIndeterminate(true);

        customRecycleView = rootView.findViewById(R.id.crv_login_collection);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        planetList = new ArrayList();
        for (int i = 0; i < 20; i++) {
            planetList.add("planeList " + i);
        }
        adapter = new LoginAdapter(planetList, getActivity());
        customRecycleView.setAdapter(adapter, layoutManager);


        customRecycleView.getSwipeRefreshLayout().setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                customRecycleView.stopRefreshing();
                Toast.makeText(getActivity(), "test", Toast.LENGTH_SHORT).show();
            }
        });


        customRecycleView.setLoadMoreLisetner(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                progress.show();
                new AsyncTask<String, Void, String>() {
                    @Override
                    protected String doInBackground(String... params) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.interrupted();
                        }
                        for (int i = 0; i < 10; i++) {
                            planetList.add("planeList " + (i + planetList.size()));
                        }
                        return "Executed";
                    }

                    @Override
                    protected void onPostExecute(String result) {
                        if (planetList.size() >= 200) {
                            customRecycleView.stopLoading();
                        }
                        adapter.notifyDataSetChanged();
                        progress.cancel();
                    }

                    @Override
                    protected void onPreExecute() {
                    }

                    @Override
                    protected void onProgressUpdate(Void... values) {
                    }
                }.execute("");
            }
        });
        return rootView;
    }


    @Override
    public void onUserLogin() {

    }

    @Override
    public void onShowError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public void onError(int code, String messageError) {

    }


}
