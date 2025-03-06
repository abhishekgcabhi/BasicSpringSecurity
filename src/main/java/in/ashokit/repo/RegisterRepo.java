package in.ashokit.repo;

import in.ashokit.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegisterRepo extends JpaRepository<Register, Long> {

    Optional<Register> findByEmail(String email);
}
