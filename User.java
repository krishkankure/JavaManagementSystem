package mgmt; // it is apart of the mgmt package

public class User { // User Object Class
    String name; // name of the user
    String job; // name of their occupation
    String city; // name of their city 
    String edu; // name of their education
    String age; // age
    public User(String n, String j, String c, String e, String a) { // constructor method for the User
      this.name = n; // assigns N which is passed through the method when called to this.name 
      this.job = j; // same this as ^^^
      this.city = c; // ^^
      this.edu = e; // ^^
      this.age = a; // ^
  	}
    public String getName() { //returns the values of the object so they can be accessed in the load class
      return name;
    }
    public String getJob() { // ^^
      return job;
    }
    public String getCity() { // ^^
      return city;
    }
    public String getEdu() { // ^^
      return edu;
    }
    public String getAge() { // ^^
      return age;
    }
}
