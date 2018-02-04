package dp.school.views.ui.fragment;

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
import dp.school.model.response.PictureResponse;
import dp.school.views.ui.adapter.PicturesAdapter;
import dp.school.utility.utils.UIUtils;
import dp.school.model.gloabal.MediaModel;
import dp.school.presenter.Implementation.PictureGalleryPresenter;
import dp.school.presenter.PresenterInterface.PictureGalleryIml;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.MediaResponse;
import dp.school.views.viewInterface.MediaView;

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

        initializeUi();
        getData();
        return rootView;
    }

    public void initializeUi(){
        rvPictures.setLayoutManager(new GridLayoutManager(getActivity().getApplicationContext(), UIUtils.calculateNoOfColumns(getActivity().getApplicationContext())));

    }

    public void getData(){
        pictureGalleryIml=new PictureGalleryPresenter(this);
        BaseRequest baseRequest=new BaseRequest();
        baseRequest.setApiToken("p8atgfTxGRRZF7ic5VszLprlMHjWc720UVnOHnDxnTnnSxK6tZe4hMaijvMhgxrC");
        pictureGalleryIml.loadMediaData(baseRequest,isPicGallery);
    }

    @Override
    public void onPicturesDataLoaded(PictureResponse media) {
        System.out.println("Loaded >>>>>>>");
        this.media=media.getData();
        System.out.println("Loaded :"+this.media.size());
            notifyAdapter();

    }

    @Override
    public void onVideosDataLoaded(MediaResponse media) {
        this.media=media.getMedia().getData();
        System.out.println("v"+media.getMedia().getData().size());
        notifyAdapter();
    }

    public void notifyAdapter(){
        picturesAdapter=new PicturesAdapter(getActivity().getApplicationContext(),media);
        picturesAdapter.setPicGallery(isPicGallery);
        rvPictures.setAdapter(picturesAdapter);
    }

    @Override
    public void onError(int code, String messageError) {
        Snackbar.make(llcontainer,messageError,Snackbar.LENGTH_LONG).show();
    }


}
