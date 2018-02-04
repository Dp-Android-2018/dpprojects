package dp.school.model.response.studentresponse;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class User implements Serializable{

	@SerializedName("image")
	private String image;

	@SerializedName("parent_address")
	private String parentAddress;

	@SerializedName("gender")
	private String gender;

	@SerializedName("class_id")
	private int classId;

	@SerializedName("own_address")
	private String ownAddress;

	@SerializedName("birth_date")
	private String birthDate;

	@SerializedName("paid_expenses")
	private int paidExpenses;

	@SerializedName("api_token")
	private String apiToken;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("ssn")
	private String ssn;

	@SerializedName("joined_bus")
	private int joinedBus;

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("branch_id")
	private int branchId;

	@SerializedName("phone")
	private String phone;

	@SerializedName("parent_id")
	private int parentId;

	@SerializedName("seat_number")
	private int seatNumber;

	@SerializedName("device_token")
	private String deviceToken;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setParentAddress(String parentAddress){
		this.parentAddress = parentAddress;
	}

	public String getParentAddress(){
		return parentAddress;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setClassId(int classId){
		this.classId = classId;
	}

	public int getClassId(){
		return classId;
	}

	public void setOwnAddress(String ownAddress){
		this.ownAddress = ownAddress;
	}

	public String getOwnAddress(){
		return ownAddress;
	}

	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public void setPaidExpenses(int paidExpenses){
		this.paidExpenses = paidExpenses;
	}

	public int getPaidExpenses(){
		return paidExpenses;
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

	public void setSsn(String ssn){
		this.ssn = ssn;
	}

	public String getSsn(){
		return ssn;
	}

	public void setJoinedBus(int joinedBus){
		this.joinedBus = joinedBus;
	}

	public int getJoinedBus(){
		return joinedBus;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setBranchId(int branchId){
		this.branchId = branchId;
	}

	public int getBranchId(){
		return branchId;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return phone;
	}

	public void setParentId(int parentId){
		this.parentId = parentId;
	}

	public int getParentId(){
		return parentId;
	}

	public void setSeatNumber(int seatNumber){
		this.seatNumber = seatNumber;
	}

	public int getSeatNumber(){
		return seatNumber;
	}

	public void setDeviceToken(String deviceToken){
		this.deviceToken = deviceToken;
	}

	public String getDeviceToken(){
		return deviceToken;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}