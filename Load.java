package mgmt;
import java.util.Scanner;
import java.util.HashMap;
public class Load {
	Scanner s = new Scanner(System.in);
	String userName;
	String jobTitle;
	HashMap<String, String> member = new HashMap<String, String>(); // matches string key (userName) to boolean (member or not);
	HashMap<String, String> jobs = new HashMap<String, String>(); // creates new hashmap with string key and string value ()
	public void takeInfo(){ // takes user info
		System.out.println("Enter your username");
		userName = s.nextLine();
		System.out.println("Enter your job title.?");
		jobTitle = s.nextLine();
		storeJob(userName, jobTitle);
		
	}
	public void storeJob(String u, String j) { // passes through u (userName) and j (jobTitle)
		jobs.put(u, j);
		System.out.println("Registered profession '" + jobs.get(userName) + "' under user '" + u +"'.");
	}
}