package backend.dating_backend;

import backend.dating_backend.controller.UserController;
import backend.dating_backend.model.UserModel;
import backend.dating_backend.service.UserService;
import backend.dating_backend.service.RecommendationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @SuppressWarnings("removal")
    @MockBean
    private UserService userService;

    @SuppressWarnings("removal")
    @MockBean
    private RecommendationService recommendationService;

    @SuppressWarnings("deprecation")
    @Test
    public void testSubmitUserData() {
        UserModel user = new UserModel("John", 25, "Male", List.of("Cooking", "Reading"));
        when(userService.addUser(any(UserModel.class))).thenReturn("User added successfully");

        ResponseEntity<Map<String, String>> response = userController.submitUserData(user);

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().containsKey("message"));
        assertEquals("User added successfully", response.getBody().get("message"));
    }
}
