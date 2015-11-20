package winter.hell.auth.dto;

/**
 * Created by ZGY on 15/11/20.
 */
public class LoginParam {

    private String user_name;

    private String password;

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginParam(String user_name) {
        this.user_name = user_name;
    }

    public LoginParam(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginParam{");
        sb.append("user_name='").append(user_name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
