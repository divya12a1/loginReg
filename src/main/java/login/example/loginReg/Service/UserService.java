package login.example.loginReg.Service;

import login.example.loginReg.Dto.LoginDto;
import login.example.loginReg.Dto.UserDto;
import login.example.loginReg.payload.response.Loginmsg;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String addUser(UserDto userDto);
    Loginmsg loginUser(LoginDto loginDto);


}
