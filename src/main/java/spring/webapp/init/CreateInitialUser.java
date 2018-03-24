package spring.webapp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import spring.webapp.database.entity.User;
import spring.webapp.database.repository.UserRepository;

@Component
public class CreateInitialUser implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public CreateInitialUser(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        User user = userRepository.findOneByEmail("mod@mod.com");
        String encodedPassword = passwordEncoder.encode("test");
        if (user == null) userRepository.save(new User("mod@mod.com", encodedPassword, "moderator"));
    }
}
