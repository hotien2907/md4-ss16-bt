package ra.thymeleaf.service;

import org.springframework.stereotype.Service;
import ra.thymeleaf.modle.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements  UserService {
    private final List<User> users = new ArrayList<>();

    @Override
    public Boolean login(User user) {
        for (User existingUser : users) {
            if (existingUser.getEmail().equals(user.getEmail()) && existingUser.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User u) {



        users.add(u);
    }


}