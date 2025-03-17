package bg.softuni.andreys.service;

import bg.softuni.andreys.config.UserSession;
import bg.softuni.andreys.dto.UserLoginDto;
import bg.softuni.andreys.entity.User;
import bg.softuni.andreys.dto.UserRegisterDto;
import bg.softuni.andreys.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserSession userSession;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserSession userSession) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userSession = userSession;
    }

    public boolean register(UserRegisterDto data) {
        Optional<User> existingUser = userRepository
                .findByUsernameOrEmail(data.getUsername(), data.getEmail());

        if (existingUser.isPresent()) {
            return false;
        }

        User user = new User();

        user.setUsername(data.getUsername());
        user.setPassword(passwordEncoder.encode(data.getPassword()));
        user.setEmail(data.getEmail());
        user.setBudget(data.getBudget());

        this.userRepository.save(user);

        return true;

    }

    public boolean login(UserLoginDto data) {
        Optional<User> byUsername = userRepository.findByUsername(data.getUsername());

        if(byUsername.isEmpty()) {
            return false;
        }

        boolean passMatch = passwordEncoder.matches(data.getPassword(), byUsername.get().getPassword());

        if(!passMatch) {
            return false;
        }
        userSession.login(byUsername.get().getId(), data.getPassword());

        return true;
    }
}
