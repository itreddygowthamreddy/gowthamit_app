package repository;

import beans.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
@Modifying
@Transactional
    @Query("update User set actionSW=:status where sno=:sno")
    public void userActionStatus(Integer sno, String status);
}

// adding comment to repository class