package winter.hell.exception;

/**
 * Created by ZGY on 15/11/18.
 */
public enum JsonExceptionCode implements IExceptionCode{
    @Desc(value = "JSON解析错误", code = "500")
    JSON_PARSE_ERROR,
}
