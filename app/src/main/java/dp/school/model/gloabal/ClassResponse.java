package dp.school.model.gloabal;

/**
 * Created by Mohamed Atef on 1/17/2018.
 */

public class ClassResponse {

    private  boolean haveClass;
    private String name;
    private String grade;
    private int numberOfStudent;


    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHaveClass() {
        return haveClass;
    }

    public void setHaveClass(boolean haveClass) {
        this.haveClass = haveClass;
    }
}
