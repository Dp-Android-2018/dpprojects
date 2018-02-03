package dp.school.presenter.Implementation;

import android.content.Context;

import com.google.gson.Gson;

import dp.school.base.baseconnection.ConnectionUtils;
import dp.school.base.baseconnection.ConnectionView;
import dp.school.base.baseconnection.WebServiceConstants;
import dp.school.presenter.PresenterInterface.PictureGalleryIml;
import dp.school.request.BaseRequest;
import dp.school.response.MediaResponse;
import dp.school.views.MediaView;

/**
 * Created by DELL on 31/01/2018.
 */

public class PictureGalleryPresenter implements PictureGalleryIml {

    private MediaView mediaView;
    public PictureGalleryPresenter(MediaView mediaView) {
        this.mediaView=mediaView;
    }

    @Override
    public void loadMediaData(BaseRequest baseRequest,boolean isPicGallery) {

      ConnectionUtils.getInstance().createConnection(baseRequest, isPicGallery ? WebServiceConstants.PICTURES_URL:WebServiceConstants.VIDEOS_URL, true, true, new ConnectionView() {
          @Override
          public void onResponseSuccess(String response) {
                mediaView.onDataLoaded(new Gson().fromJson(response,MediaResponse.class));
          }

          @Override
          public void onResponseError(int code, String message) {
                mediaView.onError(code,message);
          }

          @Override
          public Context getContext() {
              return null;
          }
      });

    }
}
