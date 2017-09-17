import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Connection {

	private DefaultResponse resp;
	private ArrayList<String> urls;

	public DefaultResponse getResp() {
		return resp;
	}

	public void setResp(DefaultResponse resp) {
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
						conn.urls.add(url);	
				}
				else{
					break;
				}
					
			}while(scanner.hasNextLine());
			
		System.out.println(conn.urls.toString());
		}
	}
	
	public ArrayList<DefaultResponse> getResponse(ArrayList<String> urls){
		ArrayList<DefaultResponse> responses = new ArrayList<DefaultResponse>();
		int timeout = 100000;
		if(urls!=null){
			for(int i=0; i<urls.size(); i++){
				try {
					DefaultResponse responseObject = new DefaultResponse();
					HashMap<Object, String> successMap = responseObject.getSuccessResponseMap();
			        HttpURLConnection connection = (HttpURLConnection) new URL(urls.get(i)).openConnection();
			        System.out.println(urls.get(i));
			        connection.setConnectTimeout(timeout);
			        connection.setReadTimeout(timeout);
			        connection.setRequestMethod("HEAD");
			        Integer responseCode = connection.getResponseCode();
			        System.out.println(urls.get(i)+responseCode);
			        responseObject.setUrl(urls.get(i));
			        responseObject.setStatusCode(responseCode);
			        responseObject.setContentLength(connection.getContentLength());
			        responseObject.setDate(((Long) connection.getDate()).toString());
			        
			        
//			        
//			        successMap.put("Url", urls.get(i));
//			        successMap.put("StatusCode", responseCode.toString());
//			        successMap.put("Content Length", "");
//			        successMap.put("Date", "");
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
	
	//check if url starts with http or https
	/**
	 * This method checks 
	 * @param url
	 * @return
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
