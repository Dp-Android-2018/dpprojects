package dp.school.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.twotoasters.jazzylistview.JazzyHelper;
import com.twotoasters.jazzylistview.effects.SlideInEffect;
import com.twotoasters.jazzylistview.recyclerview.JazzyRecyclerViewScrollListener;

import java.util.ArrayList;

import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.FeedAdapter;
import dp.school.adapter.StudentAdapter;
import dp.school.response.FeedResponse;
import dp.school.response.StudentResponse;

public class FeedsActivity extends AppCompatActivity {

    private JazzyRecyclerViewScrollListener jazzyScrollListener;
    RecyclerView studentsRecycleView;


    private static final String KEY_TRANSITION_EFFECT = "transition_effect";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeds);
        ButterKnife.bind(this);

        ArrayList<FeedResponse> feedItems = new ArrayList<>();
        for(int i=0; i<1000; i++){
            FeedResponse feedResponse = new FeedResponse();
            feedResponse.setDetails("Lorem ipsm dolor sit amet, consector adipicing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqa. Ut num ad vertual btubs "+i);
            feedItems.add(feedResponse);
        }


        studentsRecycleView =  findViewById(R.id.rv_feeds_collection);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        FeedAdapter feedAdapter = new FeedAdapter(this,feedItems);
        studentsRecycleView.setLayoutManager(layoutManager);
        studentsRecycleView.setAdapter(feedAdapter);
        jazzyScrollListener = new JazzyRecyclerViewScrollListener();
        studentsRecycleView.setOnScrollListener(jazzyScrollListener);
        jazzyScrollListener.setTransitionEffect(JazzyHelper.FLIP);
        System.out.println("Ay kalamC:\\Program Files\\Git");
    }


}
