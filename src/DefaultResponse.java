

import java.io.Serializable;
import java.util.HashMap;
/**
 * 
 * @author bturny
 *
 */
public class DefaultResponse implements Serializable{

	private static final long serialVersionUID = -5133237403603447455L;
	private Object responseObject;
	private HashMap<Object, String> errorResponseMap;
	private HashMap<Object, String> successResponseMap;
	
	public DefaultResponse(){
		this.errorResponseMap = new HashMap<Object, String>();
		this.successResponseMap = new HashMap<Object, String>();
	}

	public HashMap<Object, String> getErrorResponseMap() {
		return errorResponseMap;
	}
	public void setErrorResponseMap(HashMap<Object, String> errorResponseMap) {
		this.errorResponseMap = errorResponseMap;
	}
	public HashMap<Object, String> getSuccessResponseMap() {
		return successResponseMap;
	}
	public void setSuccessResponseMap(HashMap<Object, String> successResponseMap) {
		this.successResponseMap = successResponseMap;
	}

	public Object getResponseObject() {
		return responseObject;
	}

	public void setResponseObject(Object responseObject) {
		this.responseObject = responseObject;
	}
	
}
