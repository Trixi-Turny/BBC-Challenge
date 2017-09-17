import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Connection {
	

	private Response resp;
	private ArrayList<String> urls;

	public Response getResp() {
		return resp;
	}

	public void setResp(Response resp) {
		this.resp = resp;
	}

	public ArrayList<String> getUrls() {
		return urls;
	}

	public void setUrls(ArrayList<String> urls) {
		this.urls = urls;
	}

	public static void main(String[] args) {
		Connection conn = new Connection();
		conn.urls = new ArrayList<String>();
		String url;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the urls:\n(Press enter to finish).");
			do{
				url  = scanner.nextLine();
				if(!url.equals("")){
						conn.urls.add(url.trim());	
				}
				else{
					break;
				}
					
			}while(scanner.hasNextLine());
			
		System.out.println(conn.urls.toString());
		}
	}
	
	
	
	public ArrayList<Response> getResponse(ArrayList<String> urls) {
		ArrayList<Response> responses = new ArrayList<Response>();
		int timeout = 100000;
		if(urls!=null){
			for(int i=0; i<urls.size(); i++){
				
				try {
					Response responseObject = new Response();
					LinkedHashMap<String, String> responseMap = (LinkedHashMap<String, String>) responseObject.getResponseMap();
					if(!validStartToUrl(urls.get(i))){
						responseMap.put("Url", urls.get(i));
						responseMap.put("Error", "invalid url");
//			        	 responseObject.setUrl(urls.get(i));
//			        	 responseObject.setError("invalid url");
						System.out.println((HttpURLConnection) new URL(urls.get(i)).openConnection());
					}
	
			        else{
						
				        HttpURLConnection request = (HttpURLConnection) new URL(urls.get(i)).openConnection();
				        System.out.println(validStartToUrl(urls.get(i)));
					
				        request.setConnectTimeout(timeout);
				        request.setReadTimeout(timeout);
				        request.setRequestMethod("GET");
				        Integer responseCode = request.getResponseCode();
				    	responseMap.put("Url", urls.get(i));
						responseMap.put("StatusCode", responseCode.toString());
						responseMap.put("Content_Length", request.getContentLength()==-1? "Not available": ((Integer) request.getContentLength()).toString());
						responseMap.put("Date", convertTime(request.getDate()));
//						
//				        responseObject.setUrl(urls.get(i));
//				        responseObject.setStatusCode(responseCode);
//				        responseObject.setContentLength(request.getContentLength()==-1? "Not available": ((Integer) request.getContentLength()).toString());
//				        responseObject.setDate((convertTime(request.getDate())));
			        }
			       
			        responses.add(responseObject);
//			        (200 <= responseCode && responseCode <= 399);
			    } catch (IOException exception) {
			        
			    }
			
				//check if url starts with correct string
				//if yes -> send requests - get response data - add object to arrayList
				
			}
			
		}
		return responses;
		
		
	}
	
	/**
	 * This method converts a timestamp to a formatted date as a String.
	 * @param time - the long timestamp to convert
	 * @return the formatted date String
	 */
			
	public String convertTime(long time){
	    Date date = new Date(time);
	    Format format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
	    return format.format(date);
	}
	
	

	/**
	 * This method checks if the url starts with either http:// or https://. Case insensitive. 
	 * @param url - the url string to check 
	 * @return true or false according to validity
	 */
	public boolean validStartToUrl(String url){
		if(url!=null){
			if(url.trim().matches("^(?i)(http(s)?)://.*$")){
				return true;
			}
		}
		return false;
		
	}
}
