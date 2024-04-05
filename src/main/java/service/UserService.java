package service;

import beans.User;

import java.util.List;


public interface UserService {
    public String saveOrUpdateUserAcc(User user);
    public List<User> getAllUserAcc();
    public User getUserAcc(Integer sno);

    public String deleteUser(Integer sno);
    public boolean userActionStatus(int sno, String status);

}
