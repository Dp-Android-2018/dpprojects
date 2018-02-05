package dp.school.views.viewInterface;

import dp.school.model.response.teacherresponse.TeacherScheduleResponse;
import dp.school.utility.BaseView;

/**
 * Created by DELL on 04/02/2018.
 */

public interface ScheduleView extends BaseView{
    public void onTeacherScheduleLoaded(TeacherScheduleResponse scheduleResponse);
}
