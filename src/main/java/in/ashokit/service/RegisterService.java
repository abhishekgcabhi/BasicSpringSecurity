package in.ashokit.service;

import in.ashokit.model.Login;
import in.ashokit.model.Register;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

@Service
public interface RegisterService {

    Register register(Register register);

    Authentication login (Login login);

}
