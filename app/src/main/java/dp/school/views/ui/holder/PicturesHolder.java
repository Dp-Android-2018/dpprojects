package dp.school.views.ui.holder;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.MediaModel;
import dp.school.utility.utils.UIUtils;

/**
 * Created by DELL on 31/01/2018.
 */

public class PicturesHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_gallery_picture)
    ImageView ivGalleryPicture;

    private Context context;
    private boolean isPicGallery;
    public PicturesHolder(View itemView, Context context,boolean isPicGallery,int imageWidth) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.context=context;
        this.isPicGallery=isPicGallery;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(UIUtils.getColumnWidth(context), imageWidth);
        ivGalleryPicture.setLayoutParams(layoutParams);
    }

    public void setPictureData(MediaModel mediaModel){
       // if(isPicGallery) {
            if (mediaModel.getUrl() != null && !mediaModel.getUrl().equals("")) {

                Picasso.with(context).load(mediaModel.getUrl()).into(ivGalleryPicture);
            }


      //  }
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showZoomAbleImage();
            }
        });
    }

    private void showZoomAbleImage(){
        Dialog dialog = new Dialog(context, R.style.AppTheme);
        dialog.setContentView(R.layout.dialog_zoom_able_image);
        PhotoView zoomablImage =  dialog.findViewById(R.id.zoom_able_image);
        zoomablImage.setImageBitmap(((BitmapDrawable)ivGalleryPicture.getDrawable()).getBitmap());
        try {
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.parseColor("#45000000")));
        }catch (NullPointerException e){
            e.getStackTrace();
        }
        dialog.show();
    }
}
