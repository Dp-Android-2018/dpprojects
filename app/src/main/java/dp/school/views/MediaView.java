package dp.school.views;

import java.util.ArrayList;

import dp.school.base.BaseView;
import dp.school.model.MediaModel;
import dp.school.response.MediaResponse;

/**
 * Created by DELL on 31/01/2018.
 */

public interface MediaView extends BaseView{
    public void onDataLoaded(MediaResponse media);
}
