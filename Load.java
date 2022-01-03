package mgmt;
import java.util.Scanner;
public class Load {
	Scanner s = new Scanner(System.in);
	String userName;
	public void takeInfo(){ // takes user info and adds to hashmap function yet to be created
		System.out.println("Enter your username");
		userName = s.nextLine();		
	}
}