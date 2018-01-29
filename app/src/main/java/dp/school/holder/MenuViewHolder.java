package dp.school.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mikhaellopez.circularimageview.CircularImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;

/**
 * Created by DELL on 22/01/2018.
 */

public class MenuViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_item_menu_title)public TextView title;
    @BindView(R.id.iv_item_menu_icon)public ImageView icon;

    public MenuViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
