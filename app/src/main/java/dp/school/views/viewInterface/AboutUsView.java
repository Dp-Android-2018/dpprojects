package dp.school.views.viewInterface;

import dp.school.utility.BaseView;
import dp.school.model.response.AboutUsResponse;

/**
 * Created by DELL on 30/01/2018.
 */

public interface AboutUsView extends BaseView{

    public void displayAboutUs(AboutUsResponse aboutUsResponse);
}
