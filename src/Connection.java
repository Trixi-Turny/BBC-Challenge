import java.util.ArrayList;
import java.util.Scanner;

public class Connection {

	private DefaultResponse resp;

	public static void main(String[] args) {
		ArrayList<String> urls = new ArrayList<String>();
		boolean noMoreUrls = false;
		String url;

		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Please enter the urls:\nInput Stream will finish when you press enter twice.");
			do{
				url  = scanner.nextLine();
				if(! url.equals("")){
					urls.add(url);	
				}
				else{
					break;
				}
					
			}while(scanner.hasNextLine());
			
		System.out.println(urls.toString());
		}
	}
}
