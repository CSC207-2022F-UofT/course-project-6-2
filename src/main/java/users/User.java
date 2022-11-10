package users;

public class User {
    public String name;
    public String password;
    public int phoneNumber;

    /**
     * Construct an instance of User
     * @param name The nickname of the user.
     * @param password The password of the user.
     * @param phoneNumber The phone number of the user.
     */
    public User(String name, String password, int phoneNumber){
        this.name = name;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter methods for the three instance value.
     */
    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public int getPhoneNumber(){
        return this.phoneNumber;
    }

    /**
     * Setter methods for the instance values.
     */
    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
