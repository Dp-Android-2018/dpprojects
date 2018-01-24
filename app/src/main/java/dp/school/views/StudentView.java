package dp.school.views;


import dp.school.base.BaseView;
import dp.school.response.studentresponse.StudentResponse;


public interface StudentView extends BaseView {
    void onStudentLogined(StudentResponse teacherResponse);
}
