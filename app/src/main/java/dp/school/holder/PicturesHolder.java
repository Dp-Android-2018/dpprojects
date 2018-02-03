package dp.school.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.MediaModel;
import dp.school.request.ParentRequest;

/**
 * Created by DELL on 31/01/2018.
 */

public class PicturesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_gallery_picture)
    ImageView ivGalleryPicture;

    private Context context;
    private boolean isPicGallery;
    public PicturesHolder(View itemView, Context context,boolean isPicGallery) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.context=context;
        this.isPicGallery=isPicGallery;
    }

    public void setPictureData(MediaModel mediaModel){
        if(isPicGallery) {
            if (mediaModel.getUrl() != null && !mediaModel.getUrl().equals(""))
                Picasso.with(context).load(mediaModel.getUrl()).into(ivGalleryPicture);
        }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
