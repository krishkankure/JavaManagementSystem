package mgmt; // apart of the mgmt package
public class Driver { // main class in program
	public static void main(String[] args) throws Exception { // main method throws exception for the mainMenu because of multiple methods within
		Load l = new Load(); // new Load object
		l.mainMenu(); // calls the main menu method which is the highest level method and the main loop of the program
	}	
}