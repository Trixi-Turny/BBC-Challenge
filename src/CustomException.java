


public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1454354353453L;
	private String fieldName;

//	public CustomException(){
//		super();
//	}
	
	public CustomException(String fieldName, String errorMessage){
		super(errorMessage);
		this.fieldName = fieldName;
	}
	
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	
}