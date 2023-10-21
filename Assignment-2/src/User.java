public abstract class User {
    private String name;
    private int age;
    private String phoneNumber;
    private String email;
    private String username;
    private String password;

    public User(String name, int age, String phoneNumber, String email, String username, String password) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String name2, int age2, String phoneNumber2, String email2) {
    }

    public abstract void register();

    public abstract boolean login(String enteredUsername, String enteredPassword);
}
