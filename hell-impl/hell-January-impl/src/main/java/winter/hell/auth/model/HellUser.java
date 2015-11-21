package winter.hell.auth.model;


import java.math.BigDecimal;
import java.sql.Timestamp;

public class HellUser {
    private Integer id;

    private String mobile;

    private Integer mobileCheck;

    private Integer gender;

    private String headimage;

    private Integer headimageCheck;

    private Timestamp birthday;

    private String email;

    private String account;

    private String password;

    private String salt;

    private String signature;

    private Integer inviterId;

    private BigDecimal height;

    private String job;

    private String salary;

    private Integer hometownCityId;

    private Integer livingCityId;

    private Timestamp registerAt;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getMobileCheck() {
        return mobileCheck;
    }

    public void setMobileCheck(Integer mobileCheck) {
        this.mobileCheck = mobileCheck;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getHeadimage() {
        return headimage;
    }

    public void setHeadimage(String headimage) {
        this.headimage = headimage;
    }

    public Integer getHeadimageCheck() {
        return headimageCheck;
    }

    public void setHeadimageCheck(Integer headimageCheck) {
        this.headimageCheck = headimageCheck;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getInviterId() {
        return inviterId;
    }

    public void setInviterId(Integer inviterId) {
        this.inviterId = inviterId;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Integer getHometownCityId() {
        return hometownCityId;
    }

    public void setHometownCityId(Integer hometownCityId) {
        this.hometownCityId = hometownCityId;
    }

    public Integer getLivingCityId() {
        return livingCityId;
    }

    public void setLivingCityId(Integer livingCityId) {
        this.livingCityId = livingCityId;
    }

    public Timestamp getRegisterAt() {
        return registerAt;
    }

    public void setRegisterAt(Timestamp registerAt) {
        this.registerAt = registerAt;
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

    public HellUser() {

    }

    public HellUser(Integer id, String mobile, Integer mobileCheck, Integer gender, String headimage, Integer headimageCheck, Timestamp birthday, String email, String account, String password, String salt, String signature, Integer inviterId, BigDecimal height, String job, String salary, Integer hometownCityId, Integer livingCityId, Timestamp registerAt, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.mobile = mobile;
        this.mobileCheck = mobileCheck;
        this.gender = gender;
        this.headimage = headimage;
        this.headimageCheck = headimageCheck;
        this.birthday = birthday;
        this.email = email;
        this.account = account;
        this.password = password;
        this.salt = salt;
        this.signature = signature;
        this.inviterId = inviterId;
        this.height = height;
        this.job = job;
        this.salary = salary;
        this.hometownCityId = hometownCityId;
        this.livingCityId = livingCityId;
        this.registerAt = registerAt;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HellUser{");
        sb.append("id=").append(id);
        sb.append(", mobile='").append(mobile).append('\'');
        sb.append(", mobileCheck=").append(mobileCheck);
        sb.append(", gender=").append(gender);
        sb.append(", headimage='").append(headimage).append('\'');
        sb.append(", headimageCheck=").append(headimageCheck);
        sb.append(", birthday=").append(birthday);
        sb.append(", email='").append(email).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", salt='").append(salt).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", inviterId=").append(inviterId);
        sb.append(", height=").append(height);
        sb.append(", job='").append(job).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", hometownCityId=").append(hometownCityId);
        sb.append(", livingCityId=").append(livingCityId);
        sb.append(", registerAt=").append(registerAt);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append('}');
        return sb.toString();
    }
}