package service;

import beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    String status = null;

    @Override
    public String saveOrUpdateUserAcc(User user) {
        User user1 = userRepository.save(user);
        if (user1 == null) {
            status = "User saved succussfully";
        } else {
            status = "User updated succuussfully";
        }
        return status;
    }

    @Override
    public List<User> getAllUserAcc() {
        return (List<User>) userRepository.findAll();

    }

    @Override
    public User getUserAcc(Integer sno) {
        boolean flag = userRepository.existsById(sno);
        if (flag) {
            Optional optional = userRepository.findById(sno);
            User user = (User) optional.get();
            return user;
        } else {
            return null;
        }
    }


    @Override
    public String deleteUser(Integer sno) {
        try {
            userRepository.deleteById(sno);
            return "User Deleted Succussfully";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Deletion Failure";

    }

    @Override
    public boolean userActionStatus(int sno, String status) {
        try {
            userRepository.userActionStatus(sno, status);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

