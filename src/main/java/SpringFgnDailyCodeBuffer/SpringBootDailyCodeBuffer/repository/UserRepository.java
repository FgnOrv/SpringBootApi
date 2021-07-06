package SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.repository;

import SpringFgnDailyCodeBuffer.SpringBootDailyCodeBuffer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
    public User findAllByFirstName(String firstName);

    public User findAllByUserName(String userName);
}
