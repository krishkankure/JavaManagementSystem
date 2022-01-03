package mgmt;
import java.util.Scanner;
import java.util.HashMap;
public class Load {
	Scanner s = new Scanner(System.in);
	String userName;
	String jobTitle;
	HashMap<String, String> jobs = new HashMap<String, String>(); // creates new hashmap with string key and string value ()
	public void mainMenu(){ // takes user info
		System.out.println("What would you like to do?");
		// create a while loop that holds this under a boolean (create it) running.
		// make it so this stuff is repeatable
		
	}
	public void storeJob(String u, String j) { // passes through u (userName) and j (jobTitle)
		jobs.put(u, j); //enters the key (username) and the value (job)
		System.out.println("Registered profession '" + jobs.get(userName) + "' under user '" + u +"'.");
	}
	public void userCheck(String u) { // checks if there is already a value in the Hashmap 
		
	}
	public void takeJob() {
		System.out.println("Enter your job title.?");
		jobTitle = s.nextLine();
		storeJob(userName, jobTitle);
	}
	public void takeName() {
		System.out.println("Enter your username");
		userName = s.nextLine();
		userCheck(userName);
	}

}