package dp.school.views;


import dp.school.base.BaseView;
import dp.school.response.teacherresponse.TeacherResponse;

public interface TeacherView extends BaseView{
    void onTeacherLogined(TeacherResponse teacherResponse);
}
