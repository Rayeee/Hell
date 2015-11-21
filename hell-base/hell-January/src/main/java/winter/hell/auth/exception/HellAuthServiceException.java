package winter.hell.auth.exception;

import winter.hell.exception.HellServiceException;
import winter.hell.exception.IExceptionCode;

/**
 * Created by ZGY on 15/11/21.
 */
public class HellAuthServiceException extends HellServiceException{

    private static final long serialVersionUID = 1L;

    public HellAuthServiceException(IExceptionCode code) {
        super(code);
    }

    public HellAuthServiceException(IExceptionCode code, String message,
                                          Throwable cause) {
        super(code, message, cause);
    }

    public HellAuthServiceException(IExceptionCode code, String message) {
        super(code, message);
    }

    public HellAuthServiceException(IExceptionCode code, Throwable cause) {
        super(code, cause);
    }
}
