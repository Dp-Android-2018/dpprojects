package dp.school.views.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;

public class FeedDetailsActivity extends AppCompatActivity {

    @BindView(R.id.iv_feed_details_photo)
    ImageView ivFeedPhoto;

    @BindView(R.id.tv_feed_details_title)
    TextView tvFeedTitle;

    @BindView(R.id.tv_feed_details_sub_title)
    TextView tvFeedSubTitle;

    @BindView(R.id.tv_feed_details_text)
    TextView tvFeedDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_details);
        ButterKnife.bind(this);
    }

}
