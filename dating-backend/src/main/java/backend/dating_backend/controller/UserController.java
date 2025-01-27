package backend.dating_backend.controller;

import backend.dating_backend.model.UserModel;
import backend.dating_backend.service.UserService;
import backend.dating_backend.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // this is to handle user-related operations
    @Autowired
    private UserService userService;

    @Autowired
    private RecommendationService recommendationService;

    // Endpoint to submit user data
    @PostMapping("/submit")
    public ResponseEntity<Map<String, String>> submitUserData(@RequestBody UserModel user) {

        String result = userService.addUser(user); // this will call service

        Map<String, String> response = new HashMap<>();
        response.put("message", result); // success message will be returned in json

        return ResponseEntity.ok(response);
    }

    @GetMapping("/recommend/{userId}")
    public ResponseEntity<List<UserModel>> getRecommendedUsers(@PathVariable String userId) {

        UserModel currentUser = userService.getUserById(userId); // Fetching current user by userId

        if (currentUser != null) {
            // Fetching all users (excluding the current user)
            List<UserModel> allUsers = userService.getAllUsers();

            // Find the closest matches for the current user
            List<UserModel> recommendedUsers = recommendationService.findClosestMatches(currentUser, allUsers);

            // Returning recommended users
            if (!recommendedUsers.isEmpty()) {
                return ResponseEntity.ok(recommendedUsers);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
