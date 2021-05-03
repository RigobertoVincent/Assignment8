import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String name;
    private String password;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValidPassword(String password) {
        if (password == null) return false;
        String regex = "^(?=.{3,8}[0-9])"
                + "(?=.*[a-z])"
                + "(?=.*[A-Z])"
                + "(?=.*[@$%^&+=])"
                + "(?=.*[#])"
                + "(?=.*[_])"
                + "(?=\\S+$).{8,20}$";

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(password);
        return m.matches();
    }


}
