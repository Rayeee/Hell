package winter.hell.redis;
/**
 * 缓存异常
 * @author zhengwen
 *
 */
public class CacheLockException extends Throwable {
    /**
     * 
     */
    private static final long serialVersionUID = 1615940414879346683L;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public CacheLockException(String msg) {
        this.msg = msg;
    }

    public CacheLockException() {
    }

}
