package backend.dating_backend;

import backend.dating_backend.model.UserModel;
import backend.dating_backend.repository.UserRepository;
import backend.dating_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testAddUser() {
        UserModel user = new UserModel("John", 25, "Male", List.of("Cooking", "Reading"));
        when(userRepository.save(any(UserModel.class))).thenReturn(user);

        String result = userService.addUser(user);

        assertEquals("User added successfully", result);
        verify(userRepository, times(1)).save(user); // Verifying save method is called once
    }

    @Test
    public void testGetUserById_UserExists() {
        UserModel user = new UserModel("John", 25, "Male", List.of("Cooking", "Reading"));
        user.setId("1");
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        UserModel result = userService.getUserById("1");

        assertNotNull(result);
        assertEquals("John", result.getName());
        assertEquals(25, result.getAge());
        verify(userRepository, times(1)).findById("1"); // Verifying findById method called once
    }

    @Test
    public void testGetUserById_UserNotFound() {
        when(userRepository.findById("1")).thenReturn(Optional.empty());

        UserModel result = userService.getUserById("1");

        assertNull(result);
        verify(userRepository, times(1)).findById("1"); // Verifying findById methods called once
    }
}
