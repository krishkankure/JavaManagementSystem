package mgmt;
import java.util.Scanner;
public class Load {
	Scanner s = new Scanner(System.in);
	String userName;
	public void takeInfo(){
		System.out.println("Enter your username");
		userName = s.nextLine();		
	}
}