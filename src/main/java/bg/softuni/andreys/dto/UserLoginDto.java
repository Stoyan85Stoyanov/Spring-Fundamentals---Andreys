package bg.softuni.andreys.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class UserLoginDto {

    @NotBlank
    @Size(min = 2)
    private String username;

    @NotBlank
    @Size(min = 2)
    private String password;
}
