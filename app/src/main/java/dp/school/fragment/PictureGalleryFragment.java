package dp.school.fragment;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import dp.school.R;
import dp.school.adapter.PicturesAdapter;
import dp.school.base.utils.UIUtils;
import dp.school.model.MediaModel;
import dp.school.presenter.Implementation.PictureGalleryPresenter;
import dp.school.presenter.PresenterInterface.PictureGalleryIml;
import dp.school.request.BaseRequest;
import dp.school.response.MediaResponse;
import dp.school.views.MediaView;

/**
 * Created by Mohamed Atef on 1/29/2018.
 */

public class PictureGalleryFragment extends Fragment implements MediaView{

    @BindView(R.id.rv_pictures)
    RecyclerView rvPictures;

    @BindView(R.id.ll_container)
    LinearLayout llcontainer;
    View rootView;
    private ArrayList<MediaModel>media=new ArrayList<>();
    private PicturesAdapter picturesAdapter;
    private  PictureGalleryIml pictureGalleryIml;
    private boolean isPicGallery;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_student_pictures_layout, container, false);
        ButterKnife.bind(this,rootView);
        isPicGallery=getArguments().getBoolean("Pic");
        Toast.makeText(getActivity().getApplicationContext()," "+isPicGallery,Toast.LENGTH_LONG).show();
        initializeUi();
        getData();
        return rootView;
    }

    public void initializeUi(){
        rvPictures.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), UIUtils.calculateNoOfColumns(getActivity().getApplicationContext())));
        picturesAdapter=new PicturesAdapter(getActivity().getApplicationContext(),media);
        picturesAdapter.setPicGallery(isPicGallery);
    }

    public void getData(){
        pictureGalleryIml=new PictureGalleryPresenter(this);
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setApiToken("p8atgfTxGRRZF7ic5VszLprlMHjWc720UVnOHnDxnTnnSxK6tZe4hMaijvMhgxrC");
        pictureGalleryIml.loadMediaData(baseRequest,isPicGallery);
    }

    @Override
    public void onDataLoaded(MediaResponse media) {
        System.out.println("Loaded >>>>>>>");
        this.media=media.getMedia().getData();
        System.out.println("Loaded :"+this.media.size());
        picturesAdapter.notifyDataSetChanged();

    }

    @Override
    public void onError(int code, String messageError) {
        Snackbar.make(llcontainer,messageError,Snackbar.LENGTH_LONG).show();
    }


}
