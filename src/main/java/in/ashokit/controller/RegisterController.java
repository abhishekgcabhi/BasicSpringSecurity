package in.ashokit.controller;

import in.ashokit.model.Login;
import in.ashokit.model.Register;
import in.ashokit.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/post")
    public ResponseEntity<?> registerUser(@RequestBody Register register){
        Register registerObj = registerService.register(register);
        if(registerObj!=null){
            return ResponseEntity.ok(registerObj);
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not founds");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        Authentication authentication = registerService.login(login);
        if(authentication!=null){
            return ResponseEntity.ok(authentication);
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("LOGIN NOT AUTHORIZED");
        }
    }

}
