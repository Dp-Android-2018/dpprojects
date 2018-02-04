package dp.school.views.ui.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.response.teacherresponse.ClassesResponse;
import dp.school.presenter.Implementation.ClassesPresenter;
import dp.school.presenter.PresenterInterface.ClassPresenterIml;
import dp.school.views.ui.adapter.ClassAdapter;
import dp.school.views.viewInterface.ClassesView;


public class BaseFragment extends Fragment implements ClassesView{
    @BindView(R.id.toolbar_android)
    Toolbar androidToolbar;

    @BindView(R.id.collapsingToolbarLayoutAndroidExample)
    CollapsingToolbarLayout mCollapsingToolbarLayout;

    ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.coordinatorRootLayout)
    CoordinatorLayout mRootLayout;

    @BindView(R.id.rv_base_teacher_classes)
    RecyclerView classesRecycleView;

    View rootView;
    ClassPresenterIml classPresenterIml;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_base, container, false);
        ButterKnife.bind(this,rootView);


//////////////////////////////Connect View To Presenter //////////////////////////////////////////////////
        classPresenterIml=new ClassesPresenter(this);
        classPresenterIml.getClassesData();
 /////////////////////////////////////////////////////////////////////////////////////////////////////////
 ///////////////////////////Initialize Recycler /////////////////////////////////////////////////////
        classesRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));

  ///////////////////////////////////////////////////////////////////////////////////////////////////
        return rootView;
    }






    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onError(int code, String messageError) {
        Snackbar.make(mRootLayout,messageError,Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void getTeacherClasss(ClassesResponse classesResponse) {
        notifyAdapterChanged(classesResponse);

    }

    public void notifyAdapterChanged(ClassesResponse classesResponse){
        ClassAdapter classAdapter = new ClassAdapter(getActivity(),classesResponse.getClasses());
        classesRecycleView.setAdapter(classAdapter);
    }

    @Nullable
    @Override
    public Context getContext() {
        return getActivity();
    }
}