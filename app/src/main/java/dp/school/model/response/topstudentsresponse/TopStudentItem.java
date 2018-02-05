package dp.school.model.response.topstudentsresponse;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TopStudentItem implements Serializable{

	@SerializedName("name")
	private String name;

	@SerializedName("activity_points")
	private int activityPoints;

	@SerializedName("student_of_day_points")
	private int studentOfDayPoints;

	@SerializedName("attendance_points")
	private int attendancePoints;

	@SerializedName("quiz_points")
	private int quizPoints;

	@SerializedName("class_name")
	private String className;

	@SerializedName("points")
	private int points;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setActivityPoints(int activityPoints){
		this.activityPoints = activityPoints;
	}

	public int getActivityPoints(){
		return activityPoints;
	}

	public void setStudentOfDayPoints(int studentOfDayPoints){
		this.studentOfDayPoints = studentOfDayPoints;
	}

	public int getStudentOfDayPoints(){
		return studentOfDayPoints;
	}

	public void setAttendancePoints(int attendancePoints){
		this.attendancePoints = attendancePoints;
	}

	public int getAttendancePoints(){
		return attendancePoints;
	}

	public void setQuizPoints(int quizPoints){
		this.quizPoints = quizPoints;
	}

	public int getQuizPoints(){
		return quizPoints;
	}

	public void setClassName(String className){
		this.className = className;
	}

	public String getClassName(){
		return className;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}
}