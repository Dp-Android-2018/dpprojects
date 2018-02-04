package dp.school.views.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;

/**
 * Created by DELL on 22/01/2018.
 */

public class ParentYearsHolder extends GroupViewHolder{

    @BindView(R.id.tv_year)
    TextView tvYear;
    public ParentYearsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setTvYear(ExpandableGroup group) {
        tvYear.setText(group.getTitle());
    }
}
