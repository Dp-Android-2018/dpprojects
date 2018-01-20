package dp.school.request;


import com.google.gson.annotations.SerializedName;

public class UserRequest {
	@SerializedName("name")
	private String name;
	@SerializedName("age")
	private int age;


	public UserRequest (String name,int age){
		this.name=name;
		this.age=age;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}


}