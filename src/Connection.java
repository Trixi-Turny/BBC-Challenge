import java.util.ArrayList;
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
					if(conn.validStartToUrl(url)){
						conn.urls.add(url);	
					}
				}
				else{
					break;
				}
					
			}while(scanner.hasNextLine());
			
		System.out.println(conn.urls.toString());
		}
	}
	
	
	
	//check if url starts with http or https
	/**
	 * This method checks 
	 * @param url
	 * @return
	 */
	public boolean validStartToUrl(String url){
		if(url!=null){
			if(url.matches("^(?i)(http(s)?)://.*$")){
				return true;
			}
		}
		return false;
		
	}
}
