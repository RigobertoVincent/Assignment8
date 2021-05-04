import org.junit.jupiter.api.Test;/// Allows junit testing
import static org.assertj.core.api.Assertions.assertThat;  // Library is required to use the assertj testing assertions
import static org.junit.jupiter.api.Assertions.*; // Library is required for junit assertions which are used in tests
import static org.mockito.Mockito.mock; //library is required to create mocks of classes being used

class UserServiceImplTest {

    /**
     * This test method, will create mock of the UserDao class and Security service class which will
     * allow to get certain code coverage, we would not be able to other wise.
     * assertThat is assuring that the mock of the class has been made
     **/
    @Test
    public void creatingInstancesOfRequests() {
        UserDAO userDAO = mock(UserDAO.class);
        SecurityService securityService = mock(SecurityService.class);
        assertThat(userDAO).isInstanceOf(UserDAO.class);
        assertThat(securityService).isInstanceOf(SecurityService.class);
    }

    /**
     *TestAssignPassword
     *We create a new object of the User class called user, where we set the password of that user to "Hello"
     *assertThat grabs the  object user and its password "Hello" and compares if it is equal to set password "Hello"
     **/
    @Test
    void testAssignPassword() {
        User user = new User();
        user.setPassword("Hello");
        assertThat(user.getPassword()).isEqualTo("Hello");
    }

    /**
     * We create a new object of the User class called user, where we set the name of that user to "John"
     * assertThat grabs the  object user and its name "John" and compares whether it is equal to set name "John"
     **/
    @Test
    void testAssignUser() {
        User user = new User();
        user.setName("John");
        assertThat(user.getName()).isEqualTo("John");
    }

    /** userDaoTest
     * create a new object of the user class called testUser
     * create a new object of the userDao class called userDao
     * create a new object of the SecurityService class called securityService
     * create a new object of the userServiceImpl class called userService where we complete requirements of the userDao
     * and securityService objects created above.
     *
     * using the userService object to assign a password instead of just using the user password and assign itself
     * assuring that userDaio object is the correct userDao object used
     **/
    @Test
    void userDaoTest() throws Exception {
        User testUser = new User();
        UserDAO userDAO = new UserDAO();
        SecurityService securityService = new SecurityService();
        UserServiceImpl userService = new UserServiceImpl(userDAO,securityService);
        userService.assignPassword(testUser);
        assertThat(userDAO).isEqualTo(userDAO);
    }

    /**
     * Assuring that the user password meets the criteria met on the assignment of the regex
     **/
    @Test
    void isValidPasswordPass() {
        User user = new User();
        assertTrue(user.isValidPassword("Hello#_1234@*"));
    }

    /**
     * Assuring that the user password does not meet the criteria met on the assignment of the regex
     **/
    @Test
    void isValidPasswordFalse() {
        User user = new User();
        assertFalse(user.isValidPassword("Hello4"));
    }

    /**
     * Assuring that the user password does not meet the criteria met on the assignment of not using an underscore
     * since the password requires an underscore this is testing that regex works
     **/
    @Test
    void isValidPasswordFailUnderscore() {
        User user = new User();
        assertFalse(user.isValidPassword("Hell#o1234@*"));
    }

    /**
     * Assuring that the user password does not meet the criteria met on the assignment of the regex
     * since the user password must have lowercase letters
     **/
    @Test
    void isValidPasswordFailCapitalLetters() {
        User user = new User();
        assertFalse(user.isValidPassword("HCD212EDEDRCR"));
    }

    /**
     * Assuring that the user password does not meet the criteria met on the assignment of the rege
     * since the user password must have capital letters x
     **/
    @Test
    void isValidPasswordFailLowercaseLetters() {
        User user = new User();
        assertFalse(user.isValidPassword("dffsde21aaqeaf"));
    }
}