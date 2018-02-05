package dp.school.views.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.MapView;
import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;


public class ContactUsFragment extends Fragment {
    View rootView;
    @BindView(R.id.tv_contact_us_phones)
    TextView phonesTextView;
    @BindView(R.id.mv_contact_us_map)
    MapView mapView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this, rootView);
        phonesTextView.setText("01234567890\n01230504043\n01839435347");
        return rootView;
    }
}