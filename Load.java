package mgmt;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map;
import java.util.Map.Entry;
import java.lang.Math;
public class Load {
	boolean running = true;
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	String name;
	String job;
	String edu;
	String city;
	String age;
	Integer dummyId;
	String stdin;
	Integer dummy;
	HashMap<Integer, User> user = new HashMap<Integer, User>(); // creates new hashmap with string key and string value ()
	final static String outputFilePath = "data/krishDB.txt";
	final static String filePath = "data/kusDB.txt";
	File file = new File(outputFilePath); // created new way to print name and id to a file just edit so it has file for each hash read java for geeks article
	private static final StringBuilder res = new StringBuilder();;
	final String os = System.getProperty("os.name");
	final String arch = System.getProperty("os.arch");
	final String version = System.getProperty("os.version");
	final String jreVersion = System.getProperty("java.version");
	final String userName = System.getProperty("user.name");
	public void saveAll() {
		save(filePath, user);
	}
	public void readAll() {
		KusUtils.write("[OK] Entering KusUtils readAll...");
		readData(filePath, user);

	}
	public void clearCL() {
		try {
			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}   
        	else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static String progressBar(int pct) throws Exception{
		res.delete(0, res.length());
		int numPounds = (pct + 9) / 10;
		for (int i = 0 ; i != numPounds ; i++) {
			res.append('*');
		}
		while (res.length() != 10) {
			res.append(' ');
		}
		return res.toString();
	}
	public void startup() throws Exception {
		KusUtils.sleep(250);
		startBar();
		reScreen();
		clearCL();
		intro();
		clearCL();
		loading();
		clearCL();
		intro();
		clearCL();
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
		if (os.contains("Windows")) {
			KusUtils.write("[INFO] Detected Windows (" + arch + ") System, version " + version);
		}   
		else {
			KusUtils.write("[INFO] Detected Unix System (" + arch + "), VERSION: " + version);
		}
		KusUtils.sleep(250);
		KusUtils.write("[INFO] Using JRE Version " + jreVersion);
		KusUtils.write("[INFO] Admin User Name: " + userName);
		KusUtils.sleep(7000);

	}
	public void intro() {
		
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
		KusUtils.sleep(3000);
	}
	public void startBar() throws Exception {
		try {
			for (int i = 0 ; i <= 100 ; i++) {
				Thread.sleep(10);
				System.out.print(String.format("[%s]%d%%\r", progressBar(i), i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void reScreen() {
		clearCL();
		KusUtils.write("It is highly recommended that you make your PowerShell window maximized in order to view the program correctly.");
		System.out.println(" ");
		KusUtils.sleep(250);
		KusUtils.write("Press Enter to return to Continue");
		Scanner ns = new Scanner(System.in);
		ns.nextLine();
	}
	public void mainMenu() throws Exception{ // takes user info
		startup();
		while(running) {
			clearCL();
			KusUtils.write("| 1 = New User | 2 = Find User by ID | 3 = Print All Users | 4 Delete a user | 5 Clear all users | 6 Find User by NAME | 7 Info | 8 Exit");
			System.out.println("_____________________________________________________________________________________________________________________________________>");
			saveAll();
			
			KusUtils.write(" ");
			System.out.print("> ");
			stdin = s.nextLine();
			
			if (stdin.equals("1")) {
				clearCL();
				newUser();
			}
			else if (stdin.equals("2")) {
				clearCL();
				ppLauncher();
			}
			else if (stdin.equals("3")) {
				clearCL();
				printAll();
			}
			else if (stdin.equals("4")) {
				clearCL();
				deleteUser();
			}
			else if (stdin.equals("5")) {
				clearCL();
				confirmDelete();
			}
			else if (stdin.equals("6")) {
				clearCL();
				nameLauncher();
			}
			else if (stdin.equals("7")) {
				clearCL();
				info();
			}
			else if (stdin.equals("8")) {
				clearCL();
				System.exit(0);
			}

		}
	}
	
	public void nameLauncher(){
		
		KusUtils.write("Enter the name of requested user");
		System.out.println(" ");
		System.out.print("> ");
		String input = s.nextLine();
		findByName(input);
	}
	public void searchLogo() {
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
	public void ppLauncher() {
		searchLogo();
		System.out.println(" ");
		System.out.print("> ");
		KusUtils.write("Enter the id of the user");
		int iPass = s.nextInt();
		Integer iPassed = Integer.valueOf(iPass);
		printProfile(iPassed);
	}
	public void takeName() {
		System.out.println(" ");
		System.out.print("> ");
		String dummyName = s.nextLine();
		while(dummyName.equals("")) {
			KusUtils.write("Name can't be empty");
			System.out.println(" ");
			System.out.print("> ");
			dummyName = s.nextLine();
		}
		name = dummyName;
	}
	public void checkId() {
		dummyId = idGen();
		while(user.containsKey(dummyId)) {
			dummyId = idGen();
		}
		
	}
	public void takeCity() {
		System.out.println(" ");
		System.out.print("> ");
		String dummyCity = s.nextLine();
		while(dummyCity.equals("")) {
			KusUtils.write("City cannot be empty");
			System.out.println(" ");
			System.out.print("> ");
			dummyCity = s.nextLine();
		}
		city = dummyCity;
	}
	public void takeJob() {
		System.out.println(" ");
		System.out.print("> ");
		String dummyJob = s.nextLine(); // unemployed if left blank
		if(dummyJob.equals("")) {
			job = "Unemployed";
		}
		else {
			job = dummyJob;
		}
		
	}
	
	public void takeEdu() {
		System.out.println(" ");
		System.out.print("> ");
		String dummyEdu = s.nextLine();
		while(dummyEdu.equals("")) {
			KusUtils.write("Education cannot be empty, enter highest level of education.");
			System.out.println(" ");
			System.out.print("> ");
			dummyEdu = s.nextLine();
		}
		edu = dummyEdu;
	}
	public void takeAge() {
		System.out.println(" ");
		System.out.print("> ");
		String dummyAge = s.nextLine();
		while(dummyAge.matches(".*[a-z].*") || dummyAge.equals("")) {
			KusUtils.write("Invalid, enter age as number, nor can it be empty.");
			System.out.println(" ");
			System.out.print("> ");
			dummyAge = s.nextLine();
		}
		age = String.valueOf(Math.abs(Integer.parseInt(dummyAge)));
	}
	public void newUserLogo() {
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
	public void newUser() {
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
		User u = new User(name, job, city, edu, age);
		user.put(dummyId, u);
		KusUtils.write("Created New User under id (" + dummyId + ")");
		exit();
		clearCL();
	}
	public int idGen() {
		return r.nextInt(500);
	}
	public void info() {
		System.out.println("___   _  _______  __    _  ___   _  __   __  ______    _______                                     "); 
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
		KusUtils.write("KANKURE USER SYSTEM v1.1 BETA");
		System.out.println(" ");
		KusUtils.write("Host Info: " + os + " " + version + " (" + arch + ")");
		System.out.println(" ");
		KusUtils.write("Admin User Name: " + userName);
		System.out.println(" ");
		KusUtils.write("JRE Version: " + jreVersion);
		exit();

	}
	public void printProfile(Integer i) {
		if(user.containsKey(i)) {
			KusUtils.write("Name (id:" + i + "): " + user.get(i).getName());
			KusUtils.write("Location: " + user.get(i).getCity());	
			KusUtils.write("Current Job: " + user.get(i).getJob());
			KusUtils.write("Education: " + user.get(i).getEdu());
			KusUtils.write("Age: " + user.get(i).getAge());
		}
		else {
			KusUtils.write("No such user exists under that id");
		}
		exit();
	}
	public void printAll() {
		KusUtils.write("All Registered Users: ");
		for(int i = 0; i < 500; i++) {
			if(user.get(i) != null) {
				
				System.out.println(user.get(i).getName() + " (" + i + ")");
			}
		}
		KusUtils.sleep(250);
		KusUtils.write("Hint: use [2 - Find User] to learn more about the user.");
		exit();
	}
	public void exit() {
		System.out.println(" ");
		KusUtils.sleep(250);
		KusUtils.write("Press Enter to return to Main Menu");
		Scanner ns = new Scanner(System.in);
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