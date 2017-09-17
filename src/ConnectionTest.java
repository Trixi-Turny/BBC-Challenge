import java.util.ArrayList;

public class ConnectionTest {

	public static void main(String[] args){
		
	
		Connection conn = new Connection();
		DefaultResponse resp = new DefaultResponse();
		ArrayList<DefaultResponse> responses = new ArrayList<DefaultResponse>();
		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://www.bbc.co.uk/iplayer");
		urls.add("https://google.com");
		urls.add("bad://address");
		urls.add("http://www.bbc.co.uk/missing/thing");
		urls.add("http://not.exists.bbc.co.uk/");
		urls.add("http://www.oracle.com/technetwork/java/javase/downloads/index.html");
		urls.add("https://www.pets4homes.co.uk/images/articles/1646/large/kitten-emergencies-signs-to-look-out-for-537479947ec1c.jpg");
		urls.add("http://site.mockito.org/");
		
		conn.setUrls(urls);
		
		if(conn.getUrls()!=null){
			for(int i=0; i<conn.getUrls().size(); i++){
				//is it a valid string (http or https)
				//if yes  - ping send GET request
				//if not - throw error Bad Url
				//add error to errorsMap
				//add status code, content length, date to reponse object
				//add response object to object list
				
			}
			
			

		
		System.out.println("Test Case 1.:");
		
		
		
		
		
	}

}
