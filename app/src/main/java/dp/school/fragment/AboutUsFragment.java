package dp.school.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.ClassAdapter;
import dp.school.model.ClassResponse;
import dp.school.presenter.Implementation.AboutPresenter;
import dp.school.presenter.PresenterInterface.AboutPresenterInterface;
import dp.school.request.BaseRequest;
import dp.school.response.AboutUsResponse;
import dp.school.views.AboutUsView;


public class AboutUsFragment extends Fragment implements AboutUsView {
    @BindView(R.id.tv_about_us_text)
    TextView aboutUs;

    @BindView(R.id.ll_about)
    LinearLayout llabout;

    View rootView;

    private BaseRequest baseRequest;
    private AboutPresenterInterface aboutPresenterIml;
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