package dp.school.views.viewInterface;

import dp.school.model.response.FeedsResponse;
import dp.school.utility.BaseView;

/**
 * Created by DELL on 31/01/2018.
 */

public interface FeedsView extends BaseView {
    public void onFeedsDataLoaded(FeedsResponse feedsResponse);
}
