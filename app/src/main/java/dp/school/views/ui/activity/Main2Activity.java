package dp.school.views.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dp.school.R;
import dp.school.utility.utils.FragmentUtils;
import dp.school.views.ui.fragment.BaseFragment;

public class Main2Activity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        FragmentUtils.addFragment(Main2Activity.this,new BaseFragment(),"");
    }



}