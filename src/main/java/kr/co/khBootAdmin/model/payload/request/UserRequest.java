package kr.co.khBootAdmin.model.payload.request;

public class UserRequest {

    private Boolean active;
    private String email;
    private Boolean isEmailVerified;
    private String username;
    private String password;

    public UserRequest(Boolean active, String password, String email, Boolean isEmailVerified, String username) {
        this.active = active;
        this.password = password;
        this.email = email;
        this.isEmailVerified = isEmailVerified;
        this.username = username;

    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public String password() { return password();}
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
