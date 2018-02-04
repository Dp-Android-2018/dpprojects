package dp.school.presenter.Implementation;

import android.content.Context;

import com.android.volley.Request;
import com.google.gson.Gson;

import dp.school.model.response.PictureResponse;
import dp.school.utility.baseconnection.ConnectionUtils;
import dp.school.utility.baseconnection.ConnectionView;
import dp.school.utility.baseconnection.WebServiceConstants;
import dp.school.presenter.PresenterInterface.PictureGalleryIml;
import dp.school.model.request.BaseRequest;
import dp.school.model.response.MediaResponse;
import dp.school.views.viewInterface.MediaView;

/**
 * Created by DELL on 31/01/2018.
 */

public class PictureGalleryPresenter implements PictureGalleryIml {

    private MediaView mediaView;
    public PictureGalleryPresenter(MediaView mediaView) {
        this.mediaView=mediaView;
    }

    @Override
    public void loadMediaData(BaseRequest baseRequest, final boolean isPicGallery) {

      ConnectionUtils.getInstance().createConnection(baseRequest, isPicGallery ? WebServiceConstants.PICTURES_URL:WebServiceConstants.VIDEOS_URL, true, true, Request.Method.GET, new ConnectionView() {
          @Override
          public void onResponseSuccess(String response) {

              if(isPicGallery)
                mediaView.onPicturesDataLoaded(new Gson().fromJson(response,PictureResponse.class));
              else {
                  System.out.println("Notified As A Video ");
                  mediaView.onVideosDataLoaded(new Gson().fromJson(response, MediaResponse.class));
              }
          }

          @Override
          public void onResponseError(int code, String message) {
                mediaView.onError(code,message);
          }

          @Override
          public Context getContext() {
              return mediaView.getContext();
          }
      });

    }
}
