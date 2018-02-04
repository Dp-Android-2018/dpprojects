package dp.school.views.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;

import dp.school.R;

/**
 * Created by PC on 27/12/2017.
 */

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.PlanetViewHolder> {

    ArrayList<String> planetList;

    public LoginAdapter(ArrayList<String> planetList, Context context) {
        this.planetList = planetList;
    }

    @Override
    public LoginAdapter.PlanetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_login, parent, false);
        PlanetViewHolder viewHolder = new PlanetViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LoginAdapter.PlanetViewHolder holder, int position) {
        holder.image.setImageResource(R.drawable.ic_check_white_48dp);
        holder.text.setText(planetList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    public static class PlanetViewHolder extends RecyclerView.ViewHolder {

        protected ImageView image;
        protected TextView text;

        public PlanetViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image_id);
            text = itemView.findViewById(R.id.text_id);
        }
    }
}
