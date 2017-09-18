
import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

/**
 * This object represents a response from a web service.
 * 
 * @author bturny
 * @version 1.0
 */
public class Response implements Serializable {

	private static final long serialVersionUID = -5133237403603447455L;
	@SerializedName("Url")
	private String url;
	@SerializedName("Status_code")
	private Integer statusCode;
	@SerializedName("Content_length")
	private String contentLength;
	@SerializedName("Date")
	private String date;
	@SerializedName("Error")
	private String error;

	public Response() {

	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
