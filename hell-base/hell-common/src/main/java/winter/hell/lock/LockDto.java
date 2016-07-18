package winter.hell.lock;

/**
 * Created by Rayee on 16/6/22.
 */
public class LockDto {

    private String sysName;

    private String key;

    private long lockTime;

    private boolean isDegrade;

    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public long getLockTime() {
        return lockTime;
    }

    public void setLockTime(long lockTime) {
        this.lockTime = lockTime;
    }

    public boolean isDegrade() {
        return isDegrade;
    }

    public void setIsDegrade(boolean isDegrade) {
        this.isDegrade = isDegrade;
    }
}
