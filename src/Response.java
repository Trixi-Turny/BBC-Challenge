
import java.io.Serializable;
import java.util.LinkedHashMap;  
import java.util.Map; 
/**
 * This object represents a response from a web service.
 * 
 * @author bturny
 * @version 1.0
 */
public class Response implements Serializable {

	private static final long serialVersionUID = -5133237403603447455L;
	private String url;
	private Integer statusCode;
	private String contentLength;
	private String date;
	private String error;
	private Map<String, String>responseMap = new LinkedHashMap<String, String>(); 
	
	

	public Map<String, String> getResponseMap() {
		return responseMap;
	}

	public void setResponseObject(Map<String, String> responseMap) {
		this.responseMap = responseMap;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Response() {

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
