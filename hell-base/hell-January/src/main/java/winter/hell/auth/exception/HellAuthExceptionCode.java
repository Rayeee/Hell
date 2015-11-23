package winter.hell.auth.exception;

import winter.hell.exception.Desc;
import winter.hell.exception.IExceptionCode;

/**
 * Created by ZGY on 15/11/21.
 */
public enum HellAuthExceptionCode implements IExceptionCode{

    @Desc(value="必填项不能为空",code = "50001")
    REQUIRE_NOT_NULL,

    @Desc(value="手机号不合法",code = "50002")
    INVALID_MOBILE,

    @Desc(value="生日不合法",code = "50003")
    INVALID_BIRTHDAY,

    @Desc(value="邮箱不合法",code = "50004")
    INVALID_EMAIL,

    @Desc(value="注册失败",code = "50005")
    ERROR_REGISTER,

    @Desc(value="根据电话查询失败",code = "50006")
    ERROR_QUERY_USERINFO_BY_MOBILE,

    @Desc(value="该手机号码已被注册",code = "50007")
    ERROR_DUPLICATED_MOBILE,

    @Desc(value="MD5加密失败",code = "50008")
    ERROR_MD5_ENCRYPTION,

    @Desc(value="登录验证失败",code = "50009")
    ERROR_LOGIN_CHECK,

}
