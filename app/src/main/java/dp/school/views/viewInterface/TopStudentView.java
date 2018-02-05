package dp.school.views.viewInterface;

import dp.school.model.response.AboutUsResponse;
import dp.school.model.response.topstudentsresponse.TopStudentResponse;
import dp.school.utility.BaseView;

/**
 * Created by DELL on 30/01/2018.
 */

public interface TopStudentView extends BaseView{

    public void displayTopStudents(TopStudentResponse topStudentResponse);
}
