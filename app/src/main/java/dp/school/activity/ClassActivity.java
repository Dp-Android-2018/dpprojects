package dp.school.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.ViewPagerAdapter;

/**
 * Created by DELL on 20/01/2018.
 */

public class ClassActivity extends AppCompatActivity {


    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_layout);
        ButterKnife.bind(this);

    }


}
