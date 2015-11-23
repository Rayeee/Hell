package winter.hell.auth.dto;

/**
 * Created by ZGY on 15/11/20.
 */
public class LoginCheckParam {

    private String mobile;

    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginCheckParam() {

    }

    public LoginCheckParam(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginCheckParam{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
