package winter.hell.util;


import javax.xml.rpc.ServiceException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yes on 10/5/16.
 */
public class SHA1Util {
    private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f' };

    public static String encryptBySHA1(String msg, Integer salt) throws Exception {
        String combined = msg + salt.toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(combined.getBytes());
            byte[] encrypted = messageDigest.digest();
            return getHexText(encrypted);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

    public static String encryptBySHA1(String msg) throws Exception {
        String combined = msg;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(combined.getBytes());
            byte[] encrypted = messageDigest.digest();
            return getHexText(encrypted);
        } catch (NoSuchAlgorithmException e) {
            throw e;
        }
    }

    private static String getHexText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        for (int j = 0; j < len; ++j) {
            buf.append(hexDigits[(bytes[j] >> 4) & 0x0f]).append(hexDigits[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static void main(String[] args) throws Exception {
        byte[] bytes = { 0x31, 0x4a, 0x7b, 0x11 };
        System.out.println(SHA1Util.encryptBySHA1("dawdwa", 10));
        System.out.println("91a87fb3f15d1abbaab3021e36c90367a527d760".length());
    }

}
