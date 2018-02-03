package dp.school.views;

import dp.school.base.BaseView;
import dp.school.response.FeedsResponse;

/**
 * Created by DELL on 31/01/2018.
 */

public interface FeedsView extends BaseView {
    public void onFeedsDataLoaded(FeedsResponse feedsResponse);
}
