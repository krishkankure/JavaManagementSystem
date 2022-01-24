package mgmt;
import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map;
import java.util.Map.Entry;

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
	public void saveAll() {
		save(filePath, user);
	}
	public void readAll() {
		readData(filePath, user);

	}
	public void mainMenu(){ // takes user info
		readAll();
		while(running) {
			KusUtils.write("| 1 = New User | 2 = Find User | 3 = Print All Users | 4 Delete a user | 5 Clear all users | 6 Find by name");
			System.out.println("__________________________________________________________");
			saveAll();
			
			KusUtils.write(" ");
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
			else if (stdin.equals("6")) {
				nameLauncher();
			}
		}
	}
	
	public void nameLauncher(){
		KusUtils.write("Enter the name of requested user");
		String input = s.nextLine();
		findByName(input);
	}
	public void ppLauncher() {
		KusUtils.write("Enter the id of the user");
		int iPass = s.nextInt();
		Integer iPassed = Integer.valueOf(iPass);
		printProfile(iPassed);
	}
	public void takeName() {
		String dummyName = s.nextLine();
		while(dummyName.equals("")) {
			KusUtils.write("Name can't be empty");
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
		String dummyCity = s.nextLine();
		while(dummyCity.equals("")) {
			KusUtils.write("City cannot be empty");
			dummyCity = s.nextLine();
		}
		city = dummyCity;
	}
	public void takeJob() {
		String dummyJob = s.nextLine(); // unemployed if left blank
		if(dummyJob.equals("")) {
			dummyJob = "Unemployed";
		}
		else {
			dummyJob = job;
		}
		job = dummyJob;
	}
	
	public void takeEdu() {
		String dummyEdu = s.nextLine();
		while(dummyEdu.equals("")) {
			KusUtils.write("Education cannot be empty");
			dummyEdu = s.nextLine();
		}
		edu = dummyEdu;
	}
	public void takeAge() {
		String dummyAge = s.nextLine();
		while(dummyAge.matches(".*[a-z].*") || dummyAge.equals("")) {
			KusUtils.write("Invalid, enter age as number, nor can it be empty.");
			dummyAge = s.nextLine();
		}
		age = dummyAge;
	}
	public void newUser() {
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
		KusUtils.sleep(2000);
	}
	public int idGen() {
		return r.nextInt(500);
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
		KusUtils.sleep(2000);
	}
	public void printAll() {
		KusUtils.write("All Registered Users: ");
		for(int i = 0; i < 500; i++) {
			if(user.get(i) != null) {
				
				System.out.println(user.get(i).getName() + " (" + i + ")");
			}
		}
		KusUtils.sleep(2000);
		KusUtils.write("Hint: use [2 - Find User] to learn more about the user.");
		KusUtils.sleep(250);
	}
	public void deleteUser() {
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
		KusUtils.sleep(2000);	
	}
	public void clearDB() {
		KusUtils.write("Deleting All Registered Users: ");
		for(int i = 0; i < 500; i++) {
			if(user.get(i) != null) {
				System.out.println("Deleting " + user.get(i).getName() + " (" + i + ")");
				user.remove(i);
			}
		}
		KusUtils.sleep(2000);
	}
	public void findByName(String n) {
		for (int key : user.keySet()) {
			if(user.get(key).getName().contains(n)) {
				KusUtils.write("User: " + user.get(key).getName() + " under ID: " + key);
				
			}
		}
		KusUtils.write(" ");
		KusUtils.sleep(2000);
		KusUtils.write("Hint: use [2 - Find User] to learn more about the user.");
		KusUtils.sleep(250);
		
	}
	public void save(String path, HashMap<Integer, User> i) {
		File file = new File(path);
  
        BufferedWriter bf = null;
  
        try {
              bf = new BufferedWriter(new FileWriter(file));
              for (Map.Entry<Integer, User> entry :
                 i.entrySet()) {
                  bf.write(entry.getKey() + ":" + entry.getValue().getName() + ":" + entry.getValue().getCity() + ":" + entry.getValue().getJob() + ":" +  entry.getValue().getEdu() + ":" + entry.getValue().getAge());
  
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
  
            // read file line by line
            while ((line = br.readLine()) != null) {
  
                // split the line by :
                String[] parts = line.split(":");
  
                // first part is name, second is number
                Integer num = Integer.parseInt(parts[0].trim());
                String uName = parts[1].trim();
				String uCity = parts[2].trim();
				String uJob = parts[3].trim();
				String uEdu = parts[4].trim();
				String uAge = parts[5].trim();
				User nu = new User(uName, uJob, uCity, uEdu, uAge);
                if (num != null && !uName.equals(""))
                    i.put(num, nu);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
	}
}