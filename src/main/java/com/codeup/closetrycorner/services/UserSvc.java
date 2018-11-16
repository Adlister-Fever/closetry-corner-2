package com.codeup.closetrycorner.services;



import com.codeup.closetrycorner.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {
    @Autowired
    private UsersRepo usersRepo;


    public UserSvc(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public Iterable<User> findAll() {
        return usersRepo.findAll();
    }

    public User findOne(long id) {
        return usersRepo.findOne(id);
    }

    public User findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }

    public void save(User user){
        usersRepo.save(user);
    }

    public User editUser(User user) {
        return usersRepo.save(user);
    }

    public void deleteUser(User user) {
        usersRepo.delete(user);
    }
}
