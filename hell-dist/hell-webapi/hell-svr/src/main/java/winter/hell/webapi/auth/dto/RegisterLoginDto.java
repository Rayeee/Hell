package winter.hell.webapi.auth.dto;

/**
 * Created by ZGY on 15/11/18.
 */
public class RegisterLoginDto {

    private String username;

    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RegisterLoginDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public RegisterLoginDto() {

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("RegisterLoginDto{");
        sb.append("username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
