package mgmt; // package of mgmt
import java.io.*; // all of java.io for convinience
import java.util.Scanner; // scanner for taking input
import java.util.Random; // random for random numbers, mainly id generate
import java.util.HashMap; // hashmaps to store ids and User objects
import java.util.Properties; // For writing to files
import java.util.Map; // for referring the HashMap
import java.util.Map.Entry; // extended part of map
import java.lang.Math; // math for brief parts throughout the program
public class Load { // main class of the project
	boolean running = true; // condition that main menu runs on
	Scanner s = new Scanner(System.in); // scanner init
	Random r = new Random(); // random init
	String name; // name of user
	String job; // job of user
	String edu; // edu of user
	String city; // city of user
	String age; // age of user
	Integer dummyId; // dummyId to be checked before assigning it to the hashmap
	String stdin; // input in the main menu
	Integer dummy; 
	HashMap<Integer, User> user = new HashMap<Integer, User>(); // creates new hashmap with string key and user, an object, value 
	final static String filePath = "data/kusDB.txt"; //output path for the program to write and read from
	private static final StringBuilder res = new StringBuilder();;  // String builder for the progress bar animation.
	final String os = System.getProperty("os.name"); // finds the name of the users operating system (ie Windows MacOS Linux etc.)
	final String arch = System.getProperty("os.arch"); // find the name of the users architecture (ie amd64, i386, etc) 
	final String version = System.getProperty("os.version"); //finds the name of the users version of their os ("Windows 10", "MacOS Big Sur", "Linux Kernel 5.8");
	final String jreVersion = System.getProperty("java.version"); // finds the name of the jre version 
	final String userName = System.getProperty("user.name"); // finds the name of the user.name in their current operating system (On my personal laptop its Krish, on a school computer it would be 994806350)
	public void saveAll() { // calls the method to call the method to save under the filepath specified in the filepath string. It saves the entire user hashmap to a file.
		save(filePath, user);
	}
	public void readAll() {
		KusUtils.write("[OK] Entering KusUtils readAll..."); // as specified this is calling a method in the kureUtils class to print letter by letter with a delay
		readData(filePath, user); // reads data from filePath and it stores it in the user hashmap;

	}
	public void clearCL() { // clears the terminal screen
		try {
			if (os.contains("Windows")) { // if the os is windows, do the windows versions for clearing the screen
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}   
        	else { // otherwise do clear, a universal clearing command for both Windows and Unix
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception e) {
			e.printStackTrace(); //handles errors and exceptions and prints it
		}
		
	}
	public static String progressBar(int pct) throws Exception{ // throws exception if it were to fail.
		res.delete(0, res.length());
		int numPounds = (pct + 9) / 10;
		for (int i = 0 ; i != numPounds ; i++) { // for i increased/iterating add a * to string.
			res.append('*');
		}
		while (res.length() != 10) {
			res.append(' '); // stop when at 10
		}
		return res.toString(); //returns the bar as a string
	}
	public void startup() throws Exception {
		KusUtils.sleep(250); // sleeps=, this method is defined in KureUtils
		startBar(); // starts the bar
		reScreen(); //prompts user to maximize their terminal window as the ascii wont display properly
		clearCL(); // clears screen
		intro(); // prints logo ascii
		clearCL(); // clears
		loading(); // adds a debug screen that looks aesthetically cool and helps with the debugging of the code
		clearCL(); // clears screen
		intro(); // once again displays logo
		clearCL(); // clears again and the program starts.
	}
	public void loading() {
		KusUtils.write("[OK] Reading data..");
		readAll();
		KusUtils.sleep(250);
		KusUtils.write("[OK] Completed User Scan");
		KusUtils.sleep(250);
		KusUtils.write("[OK] Initializing KUS CLI");
		KusUtils.sleep(250);
		KusUtils.write("[OK] Detecting Info...");
		KusUtils.sleep(2500);
		if (os.contains("Windows")) { // if the OS is windows it will mention that is a windows computer
			KusUtils.write("[INFO] Detected Windows (" + arch + ") System, version " + version); // prints architecture and version
		}   
		else { // otherwise it highly likely that it is unix/unix-based operating system like Linux, MacOS, BSD.
			KusUtils.write("[INFO] Detected Unix System (" + arch + "), VERSION: " + version); // prints architecture and version
		}
		KusUtils.sleep(250);
		KusUtils.write("[INFO] Using JRE Version " + jreVersion); // prints current jre version
		KusUtils.write("[INFO] Admin User Name: " + userName); // prints the users system user name
		KusUtils.sleep(7000);

	}
	public void intro() { // cool ascii art for KUS
		
		System.out.println("___   _  _______  __    _  ___   _  __   __  ______    _______                                     "); 
		System.out.println("|   | | ||   _   ||  |  | ||   | | ||  | |  ||    _ |  |       |                                   "); 
		System.out.println("|   |_| ||  |_|  ||   |_| ||   |_| ||  | |  ||   | ||  |    ___|                                   ");  
		System.out.println("|      _||       ||       ||      _||  |_|  ||   |_||_ |   |___                                    "); 
		System.out.println("|     |_ |       ||  _    ||     |_ |       ||    __  ||    ___|                                   "); 
		System.out.println("|    _  ||   _   || | |   ||    _  ||       ||   |  | ||   |___                                    ");  
		System.out.println("|___| |_||__| |__||_|  |__||___| |_||_______||___|  |_||_______|                                   "); 
		System.out.println("__   __  _______  _______  ______            _______  __   __  _______  _______  _______  __   __  ");
		System.out.println(" |  | |  ||       ||       ||    _ |          |       ||  | |  ||       ||       ||       ||  |_| |");
		System.out.println("|  | |  ||  _____||    ___||   | ||          |  _____||  |_|  ||  _____||_     _||    ___||       |");
		System.out.println("|  |_|  || |_____ |   |___ |   |_||_         | |_____ |       || |_____   |   |  |   |___ |       |");
		System.out.println("|       ||_____  ||    ___||    __  |        |_____  ||_     _||_____  |  |   |  |    ___||       |");
		System.out.println("|       | _____| ||   |___ |   |  | | _____   _____| |  |   |   _____| |  |   |  |   |___ | ||_|| |");
		System.out.println("|_______||_______||_______||___|  |_||_____| |_______|  |___|  |_______|  |___|  |_______||_|   |_|");
		KusUtils.sleep(3000); //sleeps after it printed for the user to admire
	}
	public void startBar() throws Exception { //starts the prgress bar, throws exception to handle error
		try {
			for (int i = 0 ; i <= 100 ; i++) { // for i to 100
				Thread.sleep(10); // sleeps
				System.out.print(String.format("[%s]%d%%\r", progressBar(i), i)); // formats the bar and calls the progress bar function itself
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void reScreen() { // prompts user to maximize/resize their screen in order to display the programm properly
		clearCL();
		KusUtils.write("WARNING: It is highly recommended that you make your PowerShell window maximized in order to view the program correctly.");
		System.out.println(" ");
		KusUtils.sleep(250);
		KusUtils.write("Press Enter to return to Continue");
		Scanner ns = new Scanner(System.in); // functions as a way for the user to read and continue when done reading
		ns.nextLine();
	}
	public void mainMenu() throws Exception{ // main loop method of the programs
		startup(); // calls the entire startup method which calls sub-methods
		while(running) {
			clearCL(); //clears screen
			KusUtils.write("| 1 = New User | 2 = Find User by ID | 3 = Print All Users | 4 Delete a user | 5 Clear all users | 6 Find User by NAME | 7 Info | 8 Exit"); // list of commands prints every time
			System.out.println("_____________________________________________________________________________________________________________________________________>");
			saveAll(); // auto-saves every time the user is brought to this screen, that is always after a user is a created, thus their is a very low chance of data not being saved
			
			KusUtils.write(" "); 
			System.out.print("> "); // carrot for the user to know that they should enter text
			stdin = s.nextLine(); // takes input
			// always clearing screen below before method is called to avoid it being printed on the main menu screen 
			if (stdin.equals("1")) { // calls new user method
				clearCL();
				newUser();
			}
			else if (stdin.equals("2")) { // calls method that calls the print profile method
				clearCL();
				ppLauncher();
			}
			else if (stdin.equals("3")) { // calls print all method
				clearCL();
				printAll();
			}
			else if (stdin.equals("4")) { // calls the user deletion method
				clearCL();
				deleteUser();
			}
			else if (stdin.equals("5")) { // calls method that confirms the clearing of the entire hashmap and text files.
				clearCL();
				confirmDelete();
			}
			else if (stdin.equals("6")) { // calls the name search launcher method
				clearCL();
				nameLauncher();
			}
			else if (stdin.equals("7")) { // calls the info screen method
				clearCL();
				info();
			}
			else if (stdin.equals("8")) { // exits the program
				clearCL();
				System.exit(0); // the (0) exit code means that the program exited sucessfully.
			}

		}
	}
	
	public void nameLauncher(){ // launches name search
		
		KusUtils.write("Enter the name of requested user");
		System.out.println(" ");
		System.out.print("> ");
		String input = s.nextLine();
		findByName(input); // calls the name searching method which will then print it to the console.
	}
	public void searchLogo() {  //ascii for the find user screen
		System.out.println(" _______  ___   __    _  ______           __   __  _______  _______  ______   ");
		System.out.println("|       ||   | |  |  | ||      |         |  | |  ||       ||       ||    _ |  ");
		System.out.println("|    ___||   | |   |_| ||  _    |        |  | |  ||  _____||    ___||   | ||  ");
		System.out.println("|   |___ |   | |       || | |   |        |  |_|  || |_____ |   |___ |   |_||_ ");
		System.out.println("|    ___||   | |  _    || |_|   |        |       ||_____  ||    ___||    __  |");
		System.out.println("|   |    |   | | | |   ||       | _____  |       | _____| ||   |___ |   |  | |");
		System.out.println("|___|    |___| |_|  |__||______| |_____| |_______||_______||_______||___|  |_|");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("________________________________________________________________________");
	}
	public void ppLauncher() { // takes input and calls print profile method which passes through the integer passed through by the user.
		searchLogo();
		System.out.println(" ");
		System.out.print("> ");
		KusUtils.write("Enter the id of the user");
		int iPass = s.nextInt();
		Integer iPassed = Integer.valueOf(iPass);
		printProfile(iPassed);
	}
	public void takeName() { // takes name
		System.out.println(" ");
		System.out.print("> ");
		String dummyName = s.nextLine(); //assigns it to dummy value to be check
		while(dummyName.equals("")) {
			KusUtils.write("Name can't be empty");
			System.out.println(" ");
			System.out.print("> ");
			dummyName = s.nextLine();
		}
		name = dummyName; // when it is check in the while loop above, dummyName is assigned to name, which is the variable that is passed through for a user object
	}
	public void checkId() {
		dummyId = idGen(); // generates id 
		while(user.containsKey(dummyId)) { //check if the id already exists
			dummyId = idGen(); // if it does exist, generate another one.
		}
		
	}
	public void takeCity() { // takes user city
		System.out.println(" ");
		System.out.print("> ");
		String dummyCity = s.nextLine();
		while(dummyCity.equals("")) { // checks if null
			KusUtils.write("City cannot be empty");
			System.out.println(" ");
			System.out.print("> ");
			dummyCity = s.nextLine();
		}
		city = dummyCity; // assigns it to city
	}
	public void takeJob() { // takes user job
		System.out.println(" ");
		System.out.print("> ");
		String dummyJob = s.nextLine(); // unemployed if left blank
		if(dummyJob.equals("")) { // if null, job is unemployed
			job = "Unemployed";
		}
		else {
			job = dummyJob; // otherwise dummyJob is assigned to job
		}
		
	}
	
	public void takeEdu() { // takes user education
		System.out.println(" ");
		System.out.print("> ");
		String dummyEdu = s.nextLine(); 
		while(dummyEdu.equals("")) { // checks if null
			KusUtils.write("Education cannot be empty, enter highest level of education.");
			System.out.println(" ");
			System.out.print("> ");
			dummyEdu = s.nextLine();
		}
		edu = dummyEdu; //assigns dummyEdu to edu
	}
	public void takeAge() { // takes user age
		System.out.println(" ");
		System.out.print("> ");
		String dummyAge = s.nextLine();
		while(dummyAge.matches(".*[a-z].*") || dummyAge.equals("")) { // checks if it includes anything other than numbers or if its null
			KusUtils.write("Invalid, enter age as number, nor can it be empty.");
			System.out.println(" ");
			System.out.print("> ");
			dummyAge = s.nextLine(); // takes input again until the conditions are no longer met
		}
		age = String.valueOf(Math.abs(Integer.parseInt(dummyAge))); // assigned dummy age to age. It first converts the string to an Integer and than takes the absolute value in the case that it is a negative number
	}
	public void newUserLogo() { // ascii  art for new user screen
		System.out.println(" __    _  _______  _     _          __   __  _______  _______  ______   ");
		System.out.println("|  |  | ||       || | _ | |        |  | |  ||       ||       ||    _ |  ");
		System.out.println("|   |_| ||    ___|| || || |        |  | |  ||  _____||    ___||   | ||  ");
		System.out.println("|       ||   |___ |       |        |  |_|  || |_____ |   |___ |   |_||_ ");
		System.out.println("|  _    ||    ___||       |        |       ||_____  ||    ___||    __  |");
		System.out.println("| | |   ||   |___ |   _   | _____  |       | _____| ||   |___ |   |  | |");
		System.out.println("|_|  |__||_______||__| |__||_____| |_______||_______||_______||___|  |_|");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("________________________________________________________________________");
	}
	public void newUser() { // creates new user
		newUserLogo();
		checkId();
		KusUtils.write("What is your name?");
		takeName();
		KusUtils.write("Where do you reside?");
		takeCity();
		KusUtils.write("What job do you currently work (leave blank if unemployed)");
		takeJob();
		KusUtils.write("What university/school did you attend?");
		takeEdu();
		KusUtils.write("How old are you?");
		takeAge();
		User u = new User(name, job, city, edu, age); // creates new user objects with the values collected by the take* functions
		user.put(dummyId, u); // adds to hashmap with the id as the key and the user object as the value
		KusUtils.write("Created New User under id (" + dummyId + ")");
		exit(); // calls exit a formatting method
	}
	public int idGen() { // generates a random id between 0 and 500
		return r.nextInt(500);
	}
	public void info() { // info screen
		KusUtils.pour(" ___   _  _______  __    _  ___   _  __   __  ______    _______                                    "); // calls the pour method in KusUtils to have a faster typewriter effect 
		KusUtils.pour("|   | | ||   _   ||  |  | ||   | | ||  | |  ||    _ |  |       |                                   "); 
		KusUtils.pour("|   |_| ||  |_|  ||   |_| ||   |_| ||  | |  ||   | ||  |    ___|                                   ");  
		KusUtils.pour("|      _||       ||       ||      _||  |_|  ||   |_||_ |   |___                                    "); 
		KusUtils.pour("|     |_ |       ||  _    ||     |_ |       ||    __  ||    ___|                                   "); 
		KusUtils.pour("|    _  ||   _   || | |   ||    _  ||       ||   |  | ||   |___                                    ");  
		KusUtils.pour("|___| |_||__| |__||_|  |__||___| |_||_______||___|  |_||_______|                                   "); 
		KusUtils.pour("__   __  _______  _______  ______            _______  __   __  _______  _______  _______  __   __  ");
		KusUtils.pour(" |  | |  ||       ||       ||    _ |          |       ||  | |  ||       ||       ||       ||  |_| |");
		KusUtils.pour("|  | |  ||  _____||    ___||   | ||          |  _____||  |_|  ||  _____||_     _||    ___||       |");
		KusUtils.pour("|  |_|  || |_____ |   |___ |   |_||_         | |_____ |       || |_____   |   |  |   |___ |       |");
		KusUtils.pour("|       ||_____  ||    ___||    __  |        |_____  ||_     _||_____  |  |   |  |    ___||       |");
		KusUtils.pour("|       | _____| ||   |___ |   |  | | _____   _____| |  |   |   _____| |  |   |  |   |___ | ||_|| |");
		KusUtils.pour("|_______||_______||_______||___|  |_||_____| |_______|  |___|  |_______|  |___|  |_______||_|   |_|");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("________________________________________________________________________");
		System.out.println(" ");
		System.out.println(" ");
		KusUtils.write("KANKURE USER SYSTEM v1.1 BETA"); // version of KUS
		System.out.println(" ");
		KusUtils.write("Host Info: " + os + " " + version + " (" + arch + ")"); // prints os, the os version, and the computer architecture
		System.out.println(" ");
		KusUtils.write("Admin User Name: " + userName); // prints username, this is used to confirm full deletion of the database
		System.out.println(" ");
		KusUtils.write("JRE Version: " + jreVersion); // prints jre version
		exit(); //prompts user to exit

	}
	public void printProfile(Integer i) { // takes the i value taken by ppLauncher() and prints the info associated with the key i.
		if(user.containsKey(i)) { // the key i exists...
			KusUtils.write("Name (id:" + i + "): " + user.get(i).getName());
			KusUtils.write("Location: " + user.get(i).getCity());	
			KusUtils.write("Current Job: " + user.get(i).getJob());
			KusUtils.write("Education: " + user.get(i).getEdu());
			KusUtils.write("Age: " + user.get(i).getAge());
		}
		else { // if i is not a key in the user hashmap
			KusUtils.write("No such user exists under that id");
		}
		exit();
	}
	public void printAll() {
		KusUtils.write("All Registered Users: ");
		for(int i = 0; i < 500; i++) { // for every iteration, i increased by one, until 500, the user limit on KUS
			if(user.get(i) != null) { // if i is not null, meaning that key I exists and contains a value
				
				System.out.println(user.get(i).getName() + " (" + i + ")"); //prints it to the console.
			}
		}
		KusUtils.sleep(250);
		KusUtils.write("Hint: use [2 - Find User] to learn more about the user."); // prompts user to learn about the user
		exit();
	}
	public void exit() { // function to help condense methods as every method will end with a prompt to end
		System.out.println(" ");
		KusUtils.sleep(250);
		KusUtils.write("Press Enter to return to Main Menu");
		Scanner ns = new Scanner(System.in); 
		/* waits for user to enter scanner, because this is the last line of code, when the user presses enter, 
		the method ends and the main menu loop continues, thus bringing the user back to the main menu */
		ns.nextLine();
	}
	public void deleteLogo() {
		System.out.println(" ______   _______  ___      _______  _______  _______          __   __  _______  _______  ______   ");
		System.out.println("|      | |       ||   |    |       ||       ||       |        |  | |  ||       ||       ||    _ |  ");
		System.out.println("|  _    ||    ___||   |    |    ___||_     _||    ___|        |  | |  ||  _____||    ___||   | ||  ");
		System.out.println("| | |   ||   |___ |   |    |   |___   |   |  |   |___         |  |_|  || |_____ |   |___ |   |_||_ ");
		System.out.println("| |_|   ||    ___||   |___ |    ___|  |   |  |    ___|        |       ||_____  ||    ___||    __  |");
		System.out.println("|       ||   |___ |       ||   |___   |   |  |   |___  _____  |       | _____| ||   |___ |   |  | |");
		System.out.println("|______| |_______||_______||_______|  |___|  |_______||_____| |_______||_______||_______||___|  |_|");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("________________________________________________________________________");
	}
	public void deleteUser() {
		deleteLogo();
		KusUtils.write("Enter the id of the user");
		int iPass = s.nextInt();
		Integer iPassed = Integer.valueOf(iPass);
		if(user.get(iPassed) != null) {
			KusUtils.write("Deleted user " + user.get(iPassed).getName() + " (" + iPassed + ")");
			user.remove(iPassed);
		}
		else {
			KusUtils.write("No such user exists under that id");
		}
		exit();	
	}
	public void confirmDelete() {
		KusUtils.write("All users on this KUS DB will be erased. Enter your user name on this computer to confirm");
		Scanner s = new Scanner(System.in);
		System.out.println(" ");
		System.out.print("> ");
		String opt = s.nextLine();
		if (opt.equalsIgnoreCase(userName)) {
			clearCL();
			clearDB();
		}
		else {
			KusUtils.write("Process Aborted, incorrect User Name");
			exit();
		}
	}
	public void clearDB() {
		KusUtils.write("Deleting All Registered Users: ");
		for(int i = 0; i < 500; i++) {
			if(user.get(i) != null) {
				System.out.println("Deleting " + user.get(i).getName() + " (" + i + ")");
				user.remove(i);
			}
		}
		exit();
	}
	public void findByName(String n) {
		searchLogo();
		for (int key : user.keySet()) {
			if(user.get(key).getName().toLowerCase().contains(n)) {
				KusUtils.write("User: " + user.get(key).getName() + " under ID: " + key);
				
			}
		}
		KusUtils.write(" ");
		KusUtils.write("Hint: use [2 - Find User] to learn more about the user.");
		exit();
		
	}
	public void save(String path, HashMap<Integer, User> i) {
		File file = new File(path);
  
        BufferedWriter bf = null;
  
        try {
              bf = new BufferedWriter(new FileWriter(file));
              for (Map.Entry<Integer, User> entry :
                 i.entrySet()) {
                  bf.write(entry.getKey() + ":" + entry.getValue().getName() + ":" + entry.getValue().getJob() + ":" + entry.getValue().getCity() + ":" +  entry.getValue().getEdu() + ":" + entry.getValue().getAge());
  
                // new line
                bf.newLine();
            }
			
            bf.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
  
            try {
                  bf.close();
            }
            catch (Exception e) {
            }
        }
	}
	public void readData(String path, HashMap<Integer, User> i) {
		BufferedReader br = null;
  
        try {
              File file = new File(path);
              br = new BufferedReader(new FileReader(file));
  
            String line = null;
			KusUtils.write("[OK] Opening BufferedReader...");
			KusUtils.sleep(2000);
            // read file line by line
			int iu = 0;
            while ((line = br.readLine()) != null) {
  
                // split the line by :
                String[] parts = line.split(":");
  
                // first part is name, second is number
                Integer num = Integer.parseInt(parts[0].trim());
                String uName = parts[1].trim();
				String uJob = parts[2].trim();
				String uCity = parts[3].trim();
				String uEdu = parts[4].trim();
				String uAge = parts[5].trim();
				User nu = new User(uName, uJob, uCity, uEdu, uAge);
				KusUtils.sleep(100);
				iu += 1;
                if (num != null && !uName.equals(""))
                    i.put(num, nu);
            }
			KusUtils.write("[OK] Found " + iu + " Users");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            if (br != null) {
                try {
                    br.close();
					KusUtils.write("[OK] Closing BufferedReader");
					KusUtils.sleep(2000);
                }
                catch (Exception e) {
                };
            }
        }
	}
}