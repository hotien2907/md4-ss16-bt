package ra.thymeleaf.service;

import ra.thymeleaf.modle.entity.User;

import java.util.List;

public interface UserService {

    Boolean login(User user);
    List<User> findAll();
   void save (User u);

}
