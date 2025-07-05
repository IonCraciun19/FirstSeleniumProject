package registration.models;

public class RegisteredUser {

    private String email;
    private String password;

    public RegisteredUser setEmail(String email) {
        this.email=email;
        return this;
    }

    public RegisteredUser setPassword(String password) {
        this.password=password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}
