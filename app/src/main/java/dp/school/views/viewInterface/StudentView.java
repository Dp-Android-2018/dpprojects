package dp.school.views.viewInterface;


import dp.school.utility.BaseView;
import dp.school.model.response.studentresponse.StudentResponse;


public interface StudentView extends BaseView {
    void onStudentLogined(StudentResponse teacherResponse);
}
