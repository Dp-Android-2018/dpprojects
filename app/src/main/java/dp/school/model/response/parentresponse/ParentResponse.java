package dp.school.model.response.parentresponse;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class ParentResponse implements Serializable{

	@SerializedName("user")
	private User user;

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}
}