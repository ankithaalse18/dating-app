package backend.dating_backend.service;

import backend.dating_backend.model.UserModel;
import backend.dating_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Adding user to database
    public String addUser(UserModel user) {
        userRepository.save(user);
        return "User added successfully";
    }

    // Get user by ID
    public UserModel getUserById(String userId) {
        Optional<UserModel> user = userRepository.findById(userId);
        return user.orElse(null); // Return null if not found
    }

    // Get all users from database
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }
}
