package QuanLyThuVienGame.models;

import java.io.Serializable;

public class Account implements Serializable {

    private String name;
    private String userName;
    private String passWord;
    private String rights;
    private String email;

    public Account() {
    }

    public Account(String name, String userName, String passWord, String rights, String email) {
        this.name = name;
        this.userName = userName;
        this.passWord = passWord;
        this.rights = rights;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", rights='" + rights + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
