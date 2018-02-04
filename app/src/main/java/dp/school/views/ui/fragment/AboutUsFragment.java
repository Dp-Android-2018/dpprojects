package dp.school.views.ui.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.presenter.Implementation.AboutPresenter;
import dp.school.presenter.PresenterInterface.AboutPresenterIml;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.AboutUsResponse;
import dp.school.views.viewInterface.AboutUsView;


public class AboutUsFragment extends Fragment implements AboutUsView {
    @BindView(R.id.tv_about_us_text)
    TextView aboutUs;

    @BindView(R.id.ll_about)
    LinearLayout llabout;

    View rootView;

    private BaseRequest baseRequest;
    private AboutPresenterIml aboutPresenterIml;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_about_us, container, false);
        ButterKnife.bind(this,rootView);
        aboutUs.setMovementMethod(new ScrollingMovementMethod());
        aboutPresenterIml=new AboutPresenter(this);
        setRequestData();
        return rootView;
    }




    @Override
    public void displayAboutUs(AboutUsResponse aboutUsResponse) {
        if(aboutUsResponse!=null && aboutUsResponse.getAboutUsModel().getAbout()!=null)
             aboutUs.setText(aboutUsResponse.getAboutUsModel().getAbout());
    }

    public void setRequestData(){
       baseRequest=new BaseRequest();
        baseRequest.setApiToken("p8atgfTxGRRZF7ic5VszLprlMHjWc720UVnOHnDxnTnnSxK6tZe4hMaijvMhgxrC");
        aboutPresenterIml.getAboutData(baseRequest);
    }

    @Override
    public void onError(int code, String messageError) {
        if(messageError!=null)
        Snackbar.make(llabout,messageError, Snackbar.LENGTH_LONG).show();

    }
}