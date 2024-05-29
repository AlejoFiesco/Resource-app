
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.example.demo.business.implementation.UserBusinessImpl;
import com.example.demo.model.User;
import com.example.demo.services.implementation.UserServiceImpl;

class UserServiceImplTest {

    @Mock
    private UserBusinessImpl userBusiness;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @SuppressWarnings("deprecation")
    @Test
    void testCreateUser() throws Exception {
        User user = new User();
        user.setId("1");
        user.setName("John");
        user.setLastName("Doe");

        when(userBusiness.createUser(user)).thenReturn(user);

        ResponseEntity<User> response = userService.createUser(user);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testGetUsers() throws Exception {
        User user1 = new User();
        user1.setId("1");
        user1.setName("John");
        user1.setLastName("Doe");

        User user2 = new User();
        user2.setId("2");
        user2.setName("Jane");
        user2.setLastName("Doe");

        List<User> users = Arrays.asList(user1, user2);

        when(userBusiness.getUserList()).thenReturn(users);

        ResponseEntity<List<User>> response = userService.getUsers();

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(users, response.getBody());
    }

    @SuppressWarnings("deprecation")
    @Test
    void testGetUserById() throws Exception {
        User user = new User();
        user.setId("1");
        user.setName("John");
        user.setLastName("Doe");

        when(userBusiness.getUserById("1")).thenReturn(user);

        ResponseEntity<User> response = userService.getUserById("1");

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(user, response.getBody());
    }
}
