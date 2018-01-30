package dp.school.response.parentresponse;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class User implements Serializable{

	@SerializedName("device_toekn")
	private String deviceToekn;

	@SerializedName("code")
	private String code;

	@SerializedName("confirmation_code")
	private String confirmationCode;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("phone")
	private String phone;

	@SerializedName("api_token")
	private String apiToken;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("remember_token")
	private String rememberToken;

	@SerializedName("email")
	private String email;

	public void setDeviceToekn(String deviceToekn){
		this.deviceToekn = deviceToekn;
	}

	public String getDeviceToekn(){
		return deviceToekn;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setConfirmationCode(String confirmationCode){
		this.confirmationCode = confirmationCode;
	}

	public String getConfirmationCode(){
		return confirmationCode;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setApiToken(String apiToken){
		this.apiToken = apiToken;
	}

	public String getApiToken(){
		return apiToken;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setRememberToken(String rememberToken){
		this.rememberToken = rememberToken;
	}

	public String getRememberToken(){
		return rememberToken;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}