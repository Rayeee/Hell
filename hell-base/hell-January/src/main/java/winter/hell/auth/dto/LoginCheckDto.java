package winter.hell.auth.dto;

/**
 * Created by ZGY on 15/11/21.
 */
public class LoginCheckDto {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LoginCheckDto() {

    }

    public LoginCheckDto(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginCheckDto{");
        sb.append("token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
