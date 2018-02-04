package dp.school.views.viewInterface;


import dp.school.utility.BaseView;
import dp.school.model.response.teacherresponse.TeacherResponse;

public interface TeacherView extends BaseView{
    void onTeacherLogined(TeacherResponse teacherResponse);
}
