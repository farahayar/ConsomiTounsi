package tn.esprit.pi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.pi.entities.User;
import tn.esprit.pi.repository.UserRepository;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> retrieveUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User retrieveUserById(Long Userid) {
		
		return userRepository.findById(Userid).orElse(null);
	}

	@Override
	public User saveUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(Long Userid) {
		userRepository.deleteById(Userid);
		
	}

}