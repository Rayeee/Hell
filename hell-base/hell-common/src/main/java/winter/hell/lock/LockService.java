package winter.hell.lock;

/**
 * Created by Rayee on 16/6/22.
 */
public interface LockService {

    boolean lock(LockDto lockDto);

    boolean release(String sysName, String key);

}
