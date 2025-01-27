package backend.dating_backend.service;

import backend.dating_backend.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    // Method for finding users with highest match score
    public List<UserModel> findClosestMatches(UserModel currentUser, List<UserModel> allUsers) {
        List<UserModel> closestMatches = new ArrayList<>();

        // Sorting users based on our comparison logic
        allUsers.sort((user1, user2) -> {
            // Gender preference
            boolean user1IsOppositeGender = !user1.getGender().equals(currentUser.getGender());
            boolean user2IsOppositeGender = !user2.getGender().equals(currentUser.getGender());
            int genderComparison = Boolean.compare(user2IsOppositeGender, user1IsOppositeGender);

            if (genderComparison != 0) {
                return genderComparison;
            }

            // closest age is given more preference
            int ageDiff1 = Math.abs(user1.getAge() - currentUser.getAge());
            int ageDiff2 = Math.abs(user2.getAge() - currentUser.getAge());
            int ageComparison = Integer.compare(ageDiff1, ageDiff2);

            if (ageComparison != 0) {
                return ageComparison;
            }

            // common interests is given more preference
            long commonInterests1 = countCommonInterests(currentUser, user1);
            long commonInterests2 = countCommonInterests(currentUser, user2);
            return Long.compare(commonInterests2, commonInterests1);
        });

        // Returning 2 closest matches
        closestMatches.addAll(allUsers.subList(0, Math.min(2, allUsers.size())));
        return closestMatches;
    }

    // Helper method to count common interests
    private long countCommonInterests(UserModel user1, UserModel user2) {
        List<String> interests1 = user1.getInterests();
        List<String> interests2 = user2.getInterests();
        return interests1.stream()
                .map(String::toLowerCase)
                .filter(interest -> interests2.stream()
                        .map(String::toLowerCase)
                        .anyMatch(interest::equals))
                .count();
    }
}
