package login.example.loginReg.Controller;

import login.example.loginReg.Dto.LoginDto;
import login.example.loginReg.Dto.UserDto;
import login.example.loginReg.Service.UserService;
import login.example.loginReg.payload.response.Loginmsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private UserService userService;


    //@PostMapping(path = "/save")
    @RequestMapping(method = RequestMethod.GET, value = "/save")
    public String saveUser(@RequestBody UserDto userDto){
        String save=userService.addUser(userDto);
        return save;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
       Loginmsg loginmsg=userService.loginUser(loginDto);

        return ResponseEntity.ok("Login successful!");
    }




}
