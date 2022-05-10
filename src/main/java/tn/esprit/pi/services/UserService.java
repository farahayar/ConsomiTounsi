// package tn.esprit.pi.services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import tn.esprit.pi.entities.User;
// import tn.esprit.pi.model.UserDTO;
// import tn.esprit.pi.repository.UserRepository;

// import java.util.ArrayList;

// @Primary
// @Service
// public class UserService implements UserDetailsService {
// 	@Autowired
// 	private UserRepository User;

// 	@Autowired
// 	private PasswordEncoder bcryptEncoder;

// 	@Override
// 	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
// 		User user = User.findByUsername(username);
// 		if (user == null) {
// 			throw new UsernameNotFoundException("User not found with username: " + username);
// 		}
// 		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
// 				new ArrayList<>());
// 	}

// 	public User save(UserDTO user) {
// 		User newUser = new User();
// 		newUser.setUsername(user.getUsername());
// 		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
// 		return User.save(newUser);
// 	}
// }