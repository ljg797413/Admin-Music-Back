package kr.co.khBootAdmin.model.payload.response;

import java.time.Instant;

public class UserListResponse {

    private Long userId;
    private String email;
    private String username;
    private Boolean active;
    private Boolean emailActive;
    private Instant createdAt;

    private String gender;   // 추가
    private Integer age;     // 추가
    private String role;     // 추가 ("관리자" / "일반")

    public UserListResponse() {}

    public UserListResponse(Long userId, String email, String username, Boolean active, Boolean emailActive, Instant createdAt,
                            String gender, Integer age, String role) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.active = active;
        this.emailActive = emailActive;
        this.createdAt = createdAt;
        this.gender = gender;
        this.age = age;
        this.role = role;
    }

    // Getter/Setter 모두 추가
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public Boolean getEmailActive() { return emailActive; }
    public void setEmailActive(Boolean emailActive) { this.emailActive = emailActive; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
}
