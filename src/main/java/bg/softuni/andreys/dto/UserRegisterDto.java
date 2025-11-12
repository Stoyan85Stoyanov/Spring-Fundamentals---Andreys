package bg.softuni.andreys.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserRegisterDto {

    @NotBlank
    @Size(min = 2)
    private String username;

    @NotBlank
    @Size(min = 2)
    private String password;

    @Email
    private String email;

    @Min(value = 0)
    private BigDecimal budget;

    @NotBlank
    private String confirmPassword;
}
