public abstract class User {
    protected String name;
    protected int age;
    protected String phoneNumber;
    protected String email;
    protected String username;
    protected String password;

    public User(String name, int age, String phoneNumber, String email, String username, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }
    public User() {
        this.name = "";
        this.age = 0;
        this.phoneNumber = "";
        this.email = "";
        this.username = "";
        this.password = "";
    }

    public User(String name2, int age2, String phoneNumber2, String email2) {
    }

    public abstract void register();
    public abstract boolean login(String enteredUsername, String enteredPassword);
}
