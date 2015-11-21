package winter.hell.auth.model;

import java.sql.Timestamp;

public class HellSession {
    private Long id;

    private Integer userId;

    private String token;

    private Integer loginAccount;

    private String userEquipment;

    private String userOs;

    private String userMac;

    private Timestamp expireTime;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(Integer loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getUserEquipment() {
        return userEquipment;
    }

    public void setUserEquipment(String userEquipment) {
        this.userEquipment = userEquipment;
    }

    public String getUserOs() {
        return userOs;
    }

    public void setUserOs(String userOs) {
        this.userOs = userOs;
    }

    public String getUserMac() {
        return userMac;
    }

    public void setUserMac(String userMac) {
        this.userMac = userMac;
    }

    public Timestamp getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Timestamp expireTime) {
        this.expireTime = expireTime;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public HellSession() {

    }

    public HellSession(Long id, Integer userId, String token, Integer loginAccount, String userEquipment, String userOs, String userMac, Timestamp expireTime, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.userId = userId;
        this.token = token;
        this.loginAccount = loginAccount;
        this.userEquipment = userEquipment;
        this.userOs = userOs;
        this.userMac = userMac;
        this.expireTime = expireTime;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HellSession{");
        sb.append("id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", token='").append(token).append('\'');
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", userEquipment='").append(userEquipment).append('\'');
        sb.append(", userOs='").append(userOs).append('\'');
        sb.append(", userMac='").append(userMac).append('\'');
        sb.append(", expireTime=").append(expireTime);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }
}