package dp.school.views.ui.holder;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.model.gloabal.Children;

/**
 * Created by DELL on 22/01/2018.
 */

public class PaymentChildrensHolder extends ChildViewHolder {
    @BindView(R.id.cb_1)
    CheckBox checkBox;
    @BindView(R.id.tv_payment_data)
    TextView tvPaymentData;
    public PaymentChildrensHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setTvPaymentData(Children children) {
        tvPaymentData.setText(children.getChildrenTitle());
    }
}
