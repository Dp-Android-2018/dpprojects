package dp.school.response.studentresponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class StudentResponse implements Serializable{

	@SerializedName("user")
	private User user;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}