package in.ashokit.service.impl;

import in.ashokit.model.Login;
import in.ashokit.model.Register;
import in.ashokit.repo.RegisterRepo;
import in.ashokit.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterImpl implements RegisterService {

@Autowired
private RegisterRepo registerRepo;

@Autowired
private PasswordEncoder passwordEncoder;


    @Override
    public Register register(Register register) {
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        Register registerObj =  registerRepo.save(register);
        return registerObj;
    }


    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public Authentication login(Login login) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
        return authentication;
    }
}
