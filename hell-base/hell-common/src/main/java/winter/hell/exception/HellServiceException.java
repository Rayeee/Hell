package winter.hell.exception;

/**
 * Created by ZGY on 15/11/18.
 */
public class HellServiceException extends Exception {

    protected String errorCode;

    protected String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public HellServiceException(IExceptionCode code) {
        super(ExceptionHelper.getMessage(code));
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = this.getMessage();
    }

    public HellServiceException(IExceptionCode code, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = ExceptionHelper.getMessage(code);
    }

    public HellServiceException(IExceptionCode code, String message) {
        super(message);
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = ExceptionHelper.getMessage(code);
    }

    public HellServiceException(IExceptionCode code, Throwable cause) {
        super(ExceptionHelper.getMessage(code), cause);
        this.errorCode = ExceptionHelper.getCode(code);
        this.errorMessage = ExceptionHelper.getMessage(code);
    }

    public HellServiceException(String msg) {
        super(msg);
    }
}
