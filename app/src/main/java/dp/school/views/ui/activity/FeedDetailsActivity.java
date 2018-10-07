package dp.school.views.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.FeedModel;

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
        if(Build.VERSION.SDK_INT>=21){
            getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition));
        }
        setContentView(R.layout.activity_feed_details);
        ButterKnife.bind(this);
        setDataToUi();
    }

    public void setDataToUi(){
        FeedModel feedModel=(FeedModel)getIntent().getSerializableExtra("FeedItem");
        if(feedModel.getImage()!=null && !feedModel.getImage().equals(""))
            Picasso.with(getApplicationContext()).load(feedModel.getImage()).into(ivFeedPhoto);

        if(feedModel.getTitle()!=null)
            tvFeedTitle.setText(feedModel.getTitle());

        if(feedModel.getSubTitle()!=null)
            tvFeedSubTitle.setText(feedModel.getSubTitle());

        if(feedModel.getDetails()!=null)
            tvFeedDetails.setText(feedModel.getDetails());
    }

}
