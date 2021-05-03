import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class UserServiceImplTest {

    @Test
    public void creatingInstancesOfRequests() {
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        assertThat(userDAO).isInstanceOf(UserDAO.class);
        assertThat(securityService).isInstanceOf(SecurityService.class);
    }

    @Test
    void testAssignPassword() {
        User user = new User();
        user.setPassword("Hello");
        assertThat(user.getPassword()).isEqualTo("Hello");
    }

    @Test
    void testAssignUser() {
        User user = new User();
        user.setName("John");
        assertThat(user.getName()).isEqualTo("John");
    }

    @Test
    void userDaoTest() throws Exception {
        User testUser = new User();
        UserDAO userDAO = new UserDAO();
        SecurityService securityService = new SecurityService();
        UserServiceImpl userService = new UserServiceImpl(userDAO,securityService);
        userService.assignPassword(testUser);
        assertThat(userDAO).isEqualTo(userDAO);
    }

    @Test
    void isValidPasswordPass() {
        User user = new User();
        assertTrue(user.isValidPassword("Hello#_1234@*"));
    }

    @Test
    void isValidPasswordFalse() {
        User user = new User();
        assertFalse(user.isValidPassword("Hello4"));
    }

    @Test
    void isValidPasswordFailUnderscore() {
        User user = new User();
        assertFalse(user.isValidPassword("Hell#o1234@*"));
    }

    @Test
    void isValidPasswordFailCapitalLetters() {
        User user = new User();
        assertFalse(user.isValidPassword("HCD212EDEDRCR"));
    }

    @Test
    void isValidPasswordFailLowercaseLetters() {
        User user = new User();
        assertFalse(user.isValidPassword("dffsde21aaqeaf"));
    }
}