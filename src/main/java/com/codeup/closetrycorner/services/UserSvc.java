package com.codeup.closetrycorner.services;



import com.codeup.closetrycorner.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {
    private UsersRepo usersRepo;


    public UserSvc(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    public Iterable<User> findAll() {
        return usersRepo.findAll();
    }

    public User findOne(int id) {
        return usersRepo.findOne(id);
    }

    public User findByUsername(String username) {
        return usersRepo.findByUsername(username);
    }

    public User registerUser(User user) {
        return usersRepo.save(user);
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
