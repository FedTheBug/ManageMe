package sample;

public class User {
    private String FirstName;
    private String LastName;
    private String UserName;
    private String password;
    private String location;
    private String gender;

    public User() {
    }

    public User(String firstName, String lastName, String userName, String password, String location, String gender) {
        FirstName = firstName;
        LastName = lastName;
        UserName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    public String getGender() {
        return gender;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
