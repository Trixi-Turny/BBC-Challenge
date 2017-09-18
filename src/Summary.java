import com.google.gson.annotations.SerializedName;


/**
 * Summary Object to cater for summarizing responses for http requests
 * @author trixiturny
 * @version 1.0
 */
public class Summary {
	@SerializedName("Status_code") private Integer statusCode;
	@SerializedName("Number_of_responses") private Integer numberOfResponses;
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public Integer getNumberOfResponses() {
		return numberOfResponses;
	}
	public void setNumberOfResponses(Integer numberOfResponses) {
		this.numberOfResponses = numberOfResponses;
	}

}
