package models;

public class User {
    private String userName;
    private String userLastName;
    private String userPhoneNumber;
    private String userAdress;
    private int userId;

    public User(String userName, String userLastName, String userPhoneNumber, String userAdress, int userId) {
        this.userName = userName;
        this.userLastName = userLastName;
        this.userPhoneNumber = userPhoneNumber;
        this.userAdress = userAdress;
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserAdress() {
        return userAdress;
    }

    public void setUserAdress(String userAdress) {
        this.userAdress = userAdress;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
