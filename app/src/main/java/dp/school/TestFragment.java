package dp.school;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.test.suitebuilder.annotation.SmallTest;
import android.text.style.TextAppearanceSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import dp.school.adapter.ClassAdapter;
import dp.school.model.ClassResponse;


public class TestFragment extends Fragment  {
    Toolbar androidToolbar;
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    ActionBarDrawerToggle mDrawerToggle;
    CoordinatorLayout mRootLayout;
    RecyclerView classesRecycleView;
    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_test, container, false);
        initToolbar();
        initInstances();

        ArrayList<ClassResponse>classItems = new ArrayList<>();
        for(int i=0; i<10; i++){
            ClassResponse classResponse = new ClassResponse();
            classResponse.setGrade("First grade");
            classResponse.setName("Class name #"+(i+1));
            classResponse.setNumberOfStudent(23+i+1*3);
            classResponse.setHaveClass((i+1)%2==1);
            classItems.add(classResponse);
        }

        classesRecycleView = rootView.findViewById(R.id.listView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        ClassAdapter classAdapter = new ClassAdapter(getActivity(),classItems);
        classesRecycleView.setLayoutManager(layoutManager);
        classesRecycleView.setAdapter(classAdapter);



        return rootView;
    }


    private void initToolbar() {
        androidToolbar = rootView.findViewById(R.id.toolbar_android);
    }

    private void initInstances() {
        mRootLayout = rootView.findViewById(R.id.coordinatorRootLayout);
        mCollapsingToolbarLayout = rootView.findViewById(R.id.collapsingToolbarLayoutAndroidExample);
        mCollapsingToolbarLayout.setTitle("Mohamed Atef Abdo");
        mCollapsingToolbarLayout.setCollapsedTitleGravity(Gravity.CENTER );

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

}