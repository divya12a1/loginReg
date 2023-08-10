package login.example.loginReg.Service.UserserviceImpl;


import login.example.loginReg.Dto.LoginDto;
import login.example.loginReg.Dto.UserDto;
import login.example.loginReg.Entity.User;
import login.example.loginReg.Repository.UserRepository;
import login.example.loginReg.Service.UserService;
import login.example.loginReg.payload.response.Loginmsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserserviceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {
        User user = new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getEmail(),
                this.passwordEncoder.encode(userDto.getPassword())
        );
        userRepository.save(user);
        return user.getUsername();
    }

    @Override
    public Loginmsg loginUser(LoginDto loginDto) {
        User user1 = userRepository.findByEmail(loginDto.getEmail());
        if (user1 != null) {
            String password = loginDto.getPassword();
            String encodedpassword = user1.getPassword();
            Boolean ispwdright = passwordEncoder.matches(password, encodedpassword);
            if (ispwdright) {
                Optional<User> user = userRepository.findOneByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
                if (user.isPresent()) {
                    return new Loginmsg("login success", Boolean.TRUE);
                } else {
                    return new Loginmsg("Login Failure", Boolean.FALSE);
                }
            } else {
                return new Loginmsg("Password not match", Boolean.FALSE);
            }
        }
        return new Loginmsg("Email not exist", Boolean.FALSE);
    }
}
