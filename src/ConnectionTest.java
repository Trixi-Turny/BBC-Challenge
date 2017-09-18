
import java.util.ArrayList;
import com.google.gson.Gson;

/**
 * Test class for testing Connection functionality
 * @author trixiturny
 *
 */
public class ConnectionTest {

	/**
	 * Main method for running test cases
	 * @param args
	 */
	public static void main(String[] args) {

		Gson gson = new Gson();
		Connection conn = new Connection();
		ArrayList<String> urls = new ArrayList<String>();

		System.out.println("Test Case 1.:");
		System.out.println();
		urls.add("http://www.bbc.co.uk/iplayer");
		urls.add("https://google.com");
		urls.add("bad://address");
		urls.add("http://www.bbc.co.uk/missing/thing");
		urls.add("http://not.exists.bbc.co.uk/");
		urls.add("http://www.oracle.com/technetwork/java/javase/downloads/index.html");
		urls.add(
				"https://www.pets4homes.co.uk/images/articles/1646/large/kitten-emergencies-signs-to-look-out-for-537479947ec1c.jpg");
		urls.add("http://site.mockito.org/");
		conn.setUrls(urls);

		System.out.println("Testing the following urls :");
		System.out.println();

		for (String u : conn.getUrls()) {
			System.out.println(u);
		}
		
		System.out.println();
		System.out.println("Responses:");
		System.out.println();
		ArrayList<Response> responses = conn.getResponse(conn.getUrls());
		for (Response r : responses) {
			System.out.println(gson.toJson(r));
		}
		System.out.println();
		System.out.println("Summary:");
		System.out.println(gson.toJson(conn.getSummary(responses)));

		System.out.println("--------------------------------");
		System.out.println();
		System.out.println("Test Case 2. (added invalid characters):");
		urls.clear();
		responses.clear();
		System.out.println();
		urls.add("http://www.bbc.co.uk/iplayer");
		urls.add("https://google.com_3");
		urls.add("bad://address");
		urls.add("http://www.bbc.co.uk/missing/thing><");
		urls.add("http://not.exists.bbc.co.uk/");
		urls.add("http://www.oracle.com/technetwork/java/javase/downloads/index.html<>");
		urls.add(
				"https://www.pets4homes.co.uk/images/articles/1646/large/{~kitten-emergencies-signs-to-look-out-for-537479947ec1c.jpg");
		urls.add("http://site.mockito.org/");
		conn.setUrls(urls);

		System.out.println("Testing the following urls :");
		System.out.println();
		for (String u : urls) {
			System.out.println(u);
		}
		
		System.out.println();
		System.out.println("Responses:");
		
		responses = conn.getResponse(conn.getUrls());
		for (Response r : responses) {
			System.out.println(gson.toJson(r));
		}
		System.out.println();
		System.out.println("Summary:");
		System.out.println(gson.toJson(conn.getSummary(responses)));

		System.out.println("--------------------------------");
		System.out.println();
		System.out.println("Test Case 3 (Empty Strings, added tabs, no hostname):");
		urls.clear();
		responses.clear();
		System.out.println();
		urls.add("http://www.bbc.co.uk/iplayer");
		urls.add("");
		urls.add("bad://address");
		urls.add("http://");
		urls.add("http://not.exists.bbc.co.uk/");
		urls.add("http://www.oracle.com/technetwork/java/javase/downloads/index.html<>");
		urls.add("https://www.	pets4homes.co.uk/images/articles/1646/large/kitten-emergencies-signs-to-look-out-for-537479947ec1c.jpg");
		urls.add("http://site.mockito.org/");
		urls.add("https://www.bbc.co.uk/iplayer");
		conn.setUrls(urls);

		System.out.println("Testing the following urls :");
		System.out.println();

		for (String u : conn.getUrls()) {
			System.out.println(u);
		}
		System.out.println();
		System.out.println("Responses:");
		System.out.println();
		responses = conn.getResponse(conn.getUrls());
		for (Response r : responses) {
			System.out.println(gson.toJson(r));
		}
		
		System.out.println();
		System.out.println("Summary:");
		System.out.println(gson.toJson(conn.getSummary(responses)));

	}

}
