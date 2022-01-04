package mgmt;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map;
public class Load {
	boolean running = true;
	Scanner s = new Scanner(System.in);
	Random r = new Random();
	String name;
	String job;
	String edu;
	String city;
	String age;
	String marriage;
	Boolean married;
	Integer dummyId;
	String stdin;
	HashMap<Integer, String> names = new HashMap<Integer, String>(); // creates new hashmap with string key and string value ()
	HashMap<Integer, String> cities = new HashMap<Integer, String>(); // creates new hashmap with string key and string value ()
	HashMap<Integer, String> jobs = new HashMap<Integer, String>(); // creates new hashmap with string key and string value ()
	HashMap<Integer, String> edus = new HashMap<Integer, String>(); // creates new hashmap with string key and string value ()
	HashMap<Integer, String> ages = new HashMap<Integer, String>(); // creates new hashmap with string key and string value ()
	HashMap<Integer, Boolean> marriageStatus = new HashMap<Integer, Boolean>(); // creates new hashmap with string key and string value ()
	final static String outputFilePath = "data/krishDB.txt";
	File file = new File(outputFilePath); // created new way to print name and id to a file just edit so it has file for each hash read java for geeks article
	public void mainMenu(){ // takes user info
		System.out.println("| 1 = New User | 2 = Find User | 3 = Print All Users | 4 Delete a user | 5 Clear all users |");
		while(running) {
			save();
			System.out.println(" ");
			System.out.print("> ");
			stdin = s.nextLine();
			
			if (stdin.equals("1")) {
				newUser();
			}
			else if (stdin.equals("2")) {
				ppLauncher();
			}
			else if (stdin.equals("3")) {
				printAll();
			}
			else if (stdin.equals("4")) {
				deleteUser();
			}
			else if (stdin.equals("5")) {
				clearDB();
			}
		}
	}
	public void ppLauncher() {
		System.out.println("Enter the id of the user");
		int iPass = s.nextInt();
		Integer iPassed = Integer.valueOf(iPass);
		printProfile(iPassed);
	}
	public void newUser() {
		System.out.println("Please enter your name.");
		name = s.nextLine();
		System.out.println("What city do you reside in?");
		city = s.nextLine();
		System.out.println("What job do you currently work (Write Unemployed if needed)");
		job = s.nextLine(); // go back to make unemployed if left blank
		System.out.println("What university/school did you attend?");
		edu = s.nextLine();
		System.out.println("How old are you?");
		age = s.nextLine();
		System.out.println("Are you currently married y/n?");
		marriage = s.nextLine();
		if(marriage.equalsIgnoreCase("y")){
			married = true;
		}
		else {
			married = false;
		}
		dummyId = idGen();
		while(names.containsKey(dummyId)) {
			dummyId = idGen();
		}
		names.put(dummyId, name);
		cities.put(dummyId, city);	
		jobs.put(dummyId, job);
		edus.put(dummyId, edu);
		ages.put(dummyId, age);
		marriageStatus.put(dummyId, married);
		System.out.println("Created New User under id (" + dummyId + ")");
	}
	public int idGen() {
		return r.nextInt(500);
	}
	public void printProfile(Integer i) {
		if(names.containsKey(i)) {
			System.out.println("Name (id:" + i + "): " + names.get(i));
			System.out.println("Location: " + cities.get(i));	
			System.out.println("Current Job: " + jobs.get(i));
			System.out.println("Education: " + edus.get(i));
			System.out.println("Age: " + ages.get(i));
			System.out.println("Maritial Status:" + marriageStatus.get(i));
		}
		else {
			System.out.println("No such user exists under that id");
		}
	}
	public void printAll() {
		System.out.println("All Registered Users: ");
		for(int i = 0; i < 500; i++) {
			if(names.get(i) != null) {
				System.out.println(names.get(i) + ", " + ages.get(i));
			}
		}
	}
	public void deleteUser() {
		System.out.println("Enter the id of the user");
		int iPass = s.nextInt();
		Integer iPassed = Integer.valueOf(iPass);
		if(names.get(iPassed) != null) {
			System.out.println("Deleted user" + names.get(iPassed) + " (" + iPassed + ")");
			names.remove(iPassed);
			jobs.remove(iPassed);
			cities.remove(iPassed);
			edus.remove(iPassed);
			ages.remove(iPassed);
			marriageStatus.remove(iPassed);
		}
		else {
			System.out.println("No such user exists under that id");
		}	
	}
	public void clearDB() {
		System.out.println("Deleting All Registered Users: ");
		for(int i = 0; i < 500; i++) {
			if(names.get(i) != null) {
				System.out.println("Deleting" + names.get(i) + ", " + ages.get(i));
				names.remove(i);
				jobs.remove(i);
				cities.remove(i);
				edus.remove(i);
				ages.remove(i);
				marriageStatus.remove(i);
			}
		}
	}
	public void save() {
		File file = new File(outputFilePath);
  
        BufferedWriter bf = null;
  
        try {
  
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
  
            // iterate map entries
            for (Map.Entry<Integer, String> entry :
                 names.entrySet()) {
  
                // put key and value separated by a colon
                bf.write(entry.getKey() + ":"
                         + entry.getValue());
  
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
  
                // always close the writer
                bf.close();
            }
            catch (Exception e) {
            }
        }
	}
}