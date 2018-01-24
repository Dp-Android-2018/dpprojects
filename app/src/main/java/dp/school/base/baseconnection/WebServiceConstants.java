package dp.school.base.baseconnection;

/**
 * Created by PC on 20/12/2017.
 */

public class WebServiceConstants {
    public static final int RESPONSE_ERROR = 800;
    public static final String DEFAULT_URL = "http://192.168.1.100/master/school/public/api/";
    public static final String TEACHER_URL = DEFAULT_URL + "teacher/";
    public static final String STUDENT_URL = DEFAULT_URL + "student/";
    public static final String PARENT_URL = DEFAULT_URL + "parent/";
    public static final String FILES_URL = DEFAULT_URL + "files/";
    public static final String TEACHER_LOGIN = TEACHER_URL+"login";
    public static final String STUDENT_LOGIN = STUDENT_URL+"login";
    public static final String PARENT_LOGIN = PARENT_URL+"login";
}
