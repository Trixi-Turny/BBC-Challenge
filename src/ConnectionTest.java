
import java.util.ArrayList;
import com.google.gson.Gson;;
public class ConnectionTest {


	public static void main(String[] args) throws CustomException{
		
		Gson gson = new Gson();
		Connection conn = new Connection();
		ArrayList<String> urls = new ArrayList<String>();
		urls.add("http://www.bbc.co.uk/iplayer");
		urls.add("https://google.com_3");
		urls.add("bad://address");
		urls.add("http://www.bbc.co.uk/missing/thing");
		urls.add("http://not.exists.bbc.co.uk/");
		urls.add("http://www.oracle.com/technetwork/java/javase/downloads/index.html");
		urls.add("https://www.pets4homes.co.uk/images/articles/1646/large/kitten-emergencies-signs-to-look-out-for-537479947ec1c.jpg");
		urls.add("http://site.mockito.org/");
		
		conn.setUrls(urls);
		
	
			System.out.println("Responses:"+ gson.toJson(conn.getResponse(urls)));
		
				
		
		
			
			

		
		System.out.println("Test Case 1.:");
		
		
		
		
		
	}

}
