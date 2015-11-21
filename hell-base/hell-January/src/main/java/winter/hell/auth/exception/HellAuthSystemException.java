package winter.hell.auth.exception;

import winter.hell.exception.HellSystemException;
import winter.hell.exception.IExceptionCode;

/**
 * Created by ZGY on 15/11/21.
 */
public class HellAuthSystemException extends HellSystemException {

    private static final long serialVersionUID = -5469920394284610043L;

    public HellAuthSystemException(IExceptionCode code) {
        super(code);
    }

    public HellAuthSystemException(IExceptionCode code, String message,
                                         Throwable cause) {
        super(code, message, cause);
    }

    public HellAuthSystemException(IExceptionCode code, String message) {
        super(code, message);
    }

    public HellAuthSystemException(IExceptionCode code, Throwable cause) {
        super(code, cause);
    }
}
