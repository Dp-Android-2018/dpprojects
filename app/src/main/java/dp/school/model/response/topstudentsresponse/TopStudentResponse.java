package dp.school.model.response.topstudentsresponse;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;


public class TopStudentResponse implements Serializable{

	@SerializedName("data")
	private List<TopStudentItem> data;

	public void setData(List<TopStudentItem> data){
		this.data = data;
	}

	public List<TopStudentItem> getData(){
		return data;
	}
}