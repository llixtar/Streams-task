package app.entity;

public class User {
    private final String name;
    private final String phone;
    private final String eMail;


    public User(String name, String phone, String eMail) {
        this.name = name;
        this.phone = phone;
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public String geteMail() {
        return eMail;
    }

    @Override
    public String toString() {
        return name +
                ", phone: " + phone +
                ", eMail: " + eMail;
    }

}
