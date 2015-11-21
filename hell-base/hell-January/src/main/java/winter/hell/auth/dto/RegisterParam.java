package winter.hell.auth.dto;

import winter.hell.auth.exception.HellAuthExceptionCode;
import winter.hell.auth.exception.HellAuthServiceException;
import winter.hell.util.ValidateUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by ZGY on 15/11/21.
 */
public class RegisterParam {

    private String mobile;

    private Integer gender;

    private String headimage;

    private Long birthday;

    private String email;

    private String account;

    private String password;

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

    public RegisterParam() {

    }

    public RegisterParam(String mobile, Integer gender, String headimage, Long birthday, String email, String account, String password, String salt, String signature, Integer inviter_id, BigDecimal height, String job, String salary, Integer hometown_city_id, Integer living_city_id, Long register_at) {
        this.mobile = mobile;
        this.gender = gender;
        this.headimage = headimage;
        this.birthday = birthday;
        this.email = email;
        this.account = account;
        this.password = password;
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
        final StringBuilder sb = new StringBuilder("RegisterParam{");
        sb.append("mobile='").append(mobile).append('\'');
        sb.append(", gender=").append(gender);
        sb.append(", headimage='").append(headimage).append('\'');
        sb.append(", birthday=").append(birthday);
        sb.append(", email='").append(email).append('\'');
        sb.append(", account='").append(account).append('\'');
        sb.append(", password='").append(password).append('\'');
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

    /**
     * 注册参数验证
     * @param registerParam
     * @return
     * @throws HellAuthServiceException
     */
    public void validate(RegisterParam registerParam) throws HellAuthServiceException{
        if(!ValidateUtils.isMobile(registerParam.getMobile())){
            throw new HellAuthServiceException(HellAuthExceptionCode.INVALID_MOBILE);
        }else if(registerParam.getBirthday() >= new Date().getTime()){
            throw new HellAuthServiceException(HellAuthExceptionCode.INVALID_BIRTHDAY);
        }else if(!ValidateUtils.isEmail(registerParam.getEmail())){
            throw new HellAuthServiceException(HellAuthExceptionCode.INVALID_EMAIL);
        }
    }
}
