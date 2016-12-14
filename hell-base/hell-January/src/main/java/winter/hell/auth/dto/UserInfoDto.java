package winter.hell.auth.dto;

import java.math.BigDecimal;

/**
 * Created by ZGY on 15/11/21.
 */
public class UserInfoDto {

    private String mobile;

    private Integer mobile_check;

    private Integer gender;

    private String headimage;

    private Integer headimage_check;

    private Long birthday;

    private String email;

    private String account;

    private String salt;

    private String signature;

    private Integer inviter_id;

    private BigDecimal height;

    private String job;

    private String salary;

    private Integer hometown_city_id;

    private Integer living_city_id;

    private Long register_at;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getMobile_check() {
        return mobile_check;
    }

    public void setMobile_check(Integer mobile_check) {
        this.mobile_check = mobile_check;
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

    public Integer getHeadimage_check() {
        return headimage_check;
    }

    public void setHeadimage_check(Integer headimage_check) {
        this.headimage_check = headimage_check;
    }

    public Long getBirthday() {
        return birthday;
    }

    public void setBirthday(Long birthday) {
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

    public Integer getInviter_id() {
        return inviter_id;
    }

    public void setInviter_id(Integer inviter_id) {
        this.inviter_id = inviter_id;
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

    public Integer getHometown_city_id() {
        return hometown_city_id;
    }

    public void setHometown_city_id(Integer hometown_city_id) {
        this.hometown_city_id = hometown_city_id;
    }

    public Integer getLiving_city_id() {
        return living_city_id;
    }

    public void setLiving_city_id(Integer living_city_id) {
        this.living_city_id = living_city_id;
    }

    public Long getRegister_at() {
        return register_at;
    }

    public void setRegister_at(Long register_at) {
        this.register_at = register_at;
    }

    public UserInfoDto() {

    }

    public UserInfoDto(String mobile) {
        this.mobile = mobile;
    }

    public UserInfoDto(String mobile, Integer mobile_check, Integer gender, String headimage, Integer headimage_check, Long birthday, String email, String account, String salt, String signature, Integer inviter_id, BigDecimal height, String job, String salary, Integer hometown_city_id, Integer living_city_id, Long register_at) {
        this.mobile = mobile;
        this.mobile_check = mobile_check;
        this.gender = gender;
        this.headimage = headimage;
        this.headimage_check = headimage_check;
        this.birthday = birthday;
        this.email = email;
        this.account = account;
        this.salt = salt;
        this.signature = signature;
        this.inviter_id = inviter_id;
        this.height = height;
        this.job = job;
        this.salary = salary;
        this.hometown_city_id = hometown_city_id;
        this.living_city_id = living_city_id;
        this.register_at = register_at;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserInfoDto{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append(", mobile_check=").append(mobile_check);
        sb.append(", gender=").append(gender);
        sb.append(", headimage='").append(headimage).append('\'');
        sb.append(", headimage_check=").append(headimage_check);
        sb.append(", birthday=").append(birthday);
        sb.append(", email='").append(email).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", salt='").append(salt).append('\'');
        sb.append(", signature='").append(signature).append('\'');
        sb.append(", inviter_id=").append(inviter_id);
        sb.append(", height=").append(height);
        sb.append(", job='").append(job).append('\'');
        sb.append(", salary='").append(salary).append('\'');
        sb.append(", hometown_city_id=").append(hometown_city_id);
        sb.append(", living_city_id=").append(living_city_id);
        sb.append(", register_at=").append(register_at);
        sb.append('}');
        return sb.toString();
    }
}
