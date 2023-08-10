package login.example.loginReg.Repository;

import login.example.loginReg.Entity.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "login.example.loginReg.Repository")
public interface UserRepository extends JpaRepository<User,String> {


    Optional<User> findOneByEmailAndPassword(String email, String password);

    User findByEmail(String email);
}


