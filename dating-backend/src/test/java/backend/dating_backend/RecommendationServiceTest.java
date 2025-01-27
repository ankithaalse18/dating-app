package backend.dating_backend;

import backend.dating_backend.model.UserModel;
import backend.dating_backend.service.RecommendationService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RecommendationServiceTest {

    private RecommendationService recommendationService;

    @BeforeEach
    void setUp() {
        recommendationService = new RecommendationService();
    }

    @Test
    void testFindClosestMatches() {
        UserModel user1 = new UserModel("John", 25, "Male", List.of("Reading", "Music"));
        UserModel user2 = new UserModel("Jane", 28, "Female", List.of("Reading", "Dancing"));
        UserModel user3 = new UserModel("Paul", 30, "Male", List.of("Sports", "Music"));

        List<UserModel> allUsers = List.of(user1, user2, user3);

        List<UserModel> recommendedUsers = recommendationService.findClosestMatches(user1, allUsers);

        assertEquals(2, recommendedUsers.size());
        assertTrue(recommendedUsers.contains(user2)); // Jane should be recommended based on gender
        assertTrue(recommendedUsers.contains(user3)); // Paul should be recommended based on interests
    }
}
