import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import com.google.gson.Gson;

/**
 * Connection Object to orchestrate the logic of a GET request
 * 
 * @author trixiturny
 * @version 1.0
 */

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

	/**
	 * Main method to take user inputs
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Gson gson = new Gson();
		Connection conn = new Connection();
		ArrayList<Response> responses;
		conn.urls = new ArrayList<String>();
		String url;
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the urls:\n(Press enter to finish).");
			do {
				url = scanner.nextLine();
				if (!url.equals("")) {
					conn.urls.add(url.trim());
				} else {
					break;
				}

			} while (scanner.hasNextLine());
			responses = conn.getResponse(conn.urls);
			System.out.println("Urls Entered: " + conn.urls.toString());
			System.out.println("Responses: ");
			// Print one by one for better readability
			for (Response r : responses) {
				System.out.println(gson.toJson(r));
			}
			System.out.println(gson.toJson(conn.getSummary(responses)));
		}

	}

	/**
	 * This method takes a list of urls and gets http response header
	 * information for each
	 * 
	 * @param urls
	 *            - the urls to send GET request to
	 * @return ArrayList of Response Objects
	 */
	public ArrayList<Response> getResponse(ArrayList<String> urls) {
		ArrayList<Response> responses = new ArrayList<Response>();
		int timeout = 10000;
		if (urls != null) {
			for (int i = 0; i < urls.size(); i++) {
				Response responseObject = new Response();

				try {

					if (!validStartToUrl(urls.get(i))) {
						responseObject.setUrl(urls.get(i));
						responseObject.setError("invalid url");
					}

					else {

						HttpURLConnection request = (HttpURLConnection) new URL(urls.get(i)).openConnection();
						request.setConnectTimeout(timeout);
						request.setReadTimeout(timeout);
						request.setRequestMethod("GET");
						Integer responseCode = request.getResponseCode();
						responseObject.setUrl(urls.get(i));
						responseObject.setStatusCode(responseCode);
						responseObject.setContentLength(request.getContentLength() == -1 ? "Not available"
								: ((Integer) request.getContentLength()).toString());
						responseObject.setDate((convertTime(request.getDate())));
					}

				} catch (IllegalArgumentException e) {
					responseObject.setUrl(urls.get(i));
					responseObject.setError(e.getMessage());
				} catch (SocketTimeoutException e) {
					responseObject.setUrl(urls.get(i));
					responseObject.setError("Connection Timeout");
				} catch (UnknownHostException e) {
					responseObject.setUrl(urls.get(i));
					responseObject.setError(
							"Site can not be reached. Check that the url is correct or that you are connected to the internet.");
				} catch (IOException e) {
					responseObject.setUrl(urls.get(i));
					responseObject.setError(e.getMessage());
				} finally {
					responses.add(responseObject);
				}

			}

		}
		return responses;

	}

	/**
	 * This method converts a timestamp to a formatted date as a String.
	 * 
	 * @param time
	 *            - the long timestamp to convert
	 * @return the formatted date String
	 */

	public String convertTime(long time) {
		Date date = new Date(time);
		Format format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
		return format.format(date);
	}

	/**
	 * This method checks if the url starts with either http:// or https:// and
	 * if it contains forbidden characters, such as ~`^{}<>"^. The check is Case
	 * insensitive.
	 * 
	 * @param url
	 *            - the url string to check
	 * @return true or false according to validity
	 */
	public boolean validStartToUrl(String url) {
		if (url != null) {
			if (url.trim().matches("^(?i)(http(s)?)://.[^\\s|\\t|\\r|\\n|\\{|\\}|<|>|\"|~|`|^]*$")) {
				return true;
			}
		}
		return false;

	}

	/**
	 * This method counts the number of responses for each status code
	 * 
	 * @param responses
	 * @return ArrayList of Summary Objects
	 */
	public ArrayList<Summary> getSummary(ArrayList<Response> responses) {
		HashMap<Integer, Integer> summary = new HashMap<Integer, Integer>();
		ArrayList<Summary> summaryList = new ArrayList<Summary>();
		if (responses != null) {
			for (int i = 0; i < responses.size(); i++) {
				Integer key = responses.get(i).getStatusCode();
				if (key != null) {
					if (summary.containsKey(key)) {
						summary.put(key, summary.get(key) + 1);
					} else {
						summary.put(key, 1);
					}
				}
			}
			Iterator it = summary.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				Summary sumObject = new Summary();
				sumObject.setStatusCode((Integer) pair.getKey());
				sumObject.setNumberOfResponses((Integer) pair.getValue());
				summaryList.add(sumObject);
				it.remove(); // avoids a ConcurrentModificationException
			}
		}

		return summaryList;
	}
}