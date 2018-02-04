package dp.school.views.viewInterface;

import dp.school.model.response.PictureResponse;
import dp.school.utility.BaseView;
import dp.school.model.response.MediaResponse;

/**
 * Created by DELL on 31/01/2018.
 */

public interface MediaView extends BaseView{
    public void onPicturesDataLoaded(PictureResponse media);

    public void onVideosDataLoaded(MediaResponse media);
}
