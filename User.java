package mgmt;

public class User {
    String name;
    String job;
    String city;
    String edu;
    String age;
    public User(String n, String j, String c, String e, String a) {
      this.name = n;
      this.job = j;
      this.city = c;
      this.edu = e;
      this.age = a;
  	}
    public String getName() {
      return name;
    }
    public String getJob() {
      return job;
    }
    public String getCity() {
      return name;
    }
    public String getEdu() {
      return edu;
    }
    public String getAge() {
      return age;
    }
}
