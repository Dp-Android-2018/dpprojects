package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import dp.school.R;
import dp.school.views.ui.holder.PicturesHolder;
import dp.school.model.gloabal.MediaModel;

/**
 * Created by DELL on 31/01/2018.
 */

public class PicturesAdapter extends RecyclerView.Adapter<PicturesHolder> {

    private Context context;
    private ArrayList<MediaModel> mediaModels;
    private boolean isPicGallery;
    public PicturesAdapter(Context context, ArrayList<MediaModel> mediaModels) {
        this.context = context;
        this.mediaModels = mediaModels;
    }

    @Override
    public PicturesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_picture_layout, parent, false);
        return new PicturesHolder(v, context,isPicGallery);
    }

    @Override
    public void onBindViewHolder(PicturesHolder holder, int position) {
        holder.setPictureData(mediaModels.get(position));

    }

    @Override
    public int getItemCount() {
        return mediaModels.size();
    }


    public void setPicGallery(boolean isPicGallery) {
        this.isPicGallery=isPicGallery;
    }
}

