package dp.school.views.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;

public class ErrorActivity extends AppCompatActivity {
    @BindView(R.id.tv_error_message)
    TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection_error);
        ButterKnife.bind(this);
        errorMessage.setText(getIntent().getStringExtra("errorMessage"));
    }
}
