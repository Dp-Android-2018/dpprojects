package dp.school.response;


public class AssignmentResponse {
    private String studentName;
    private String studentPhoto;
    private boolean isFinished;

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentPhoto(String studentPhoto) {
        this.studentPhoto = studentPhoto;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentPhoto() {
        return studentPhoto;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }
}