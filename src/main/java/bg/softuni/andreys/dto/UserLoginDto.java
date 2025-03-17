package bg.softuni.andreys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserLoginDto {

    @NotBlank
    @Size(min = 2)
    private String username;

    @NotBlank
    @Size(min = 2)
    private String password;

    public UserLoginDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
