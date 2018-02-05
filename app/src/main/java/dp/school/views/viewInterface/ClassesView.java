package dp.school.views.viewInterface;

import dp.school.model.response.teacherresponse.ClassesResponse;
import dp.school.utility.BaseView;

/**
 * Created by DELL on 04/02/2018.
 */

public interface ClassesView extends BaseView{

    public void getTeacherClasss(ClassesResponse classesResponse);
}
