package tn.esprit.pi.services;

import java.util.List;

import tn.esprit.pi.entities.User;

public interface IUserService {
    List<User> retrieveUsers();

    User retrieveUserById(Long Userid);

    User saveUser(User u);

    User updateUser(User u);

    void deleteUser(Long Userid);

}