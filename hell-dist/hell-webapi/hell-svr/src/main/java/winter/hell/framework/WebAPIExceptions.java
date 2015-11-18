package winter.hell.framework;


import winter.hell.exception.Desc;
import winter.hell.exception.IExceptionCode;

public enum WebAPIExceptions implements IExceptionCode {

	@Desc("无效身份")
	ERR_AUTH_FAILED(),

	@Desc("无效请求")
	ERR_BAD_REQUEST(),

	@Desc("未知错误")
	ERR_UNKNOWN(),

	@Desc("校验错误")
	ERR_WEBAPI_VALIDATION(),

	@Desc(value = "token验证失败", code = "50020")
	REQUEST_CHECK_TOKEN,
}
