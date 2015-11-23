package winter.hell.util;

import org.apache.commons.codec.binary.Hex;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ZGY on 15/11/23.
 */
public class Md5Utils {

    /**
     * MD5加密
     * @param source
     * @return
     * @throws NoSuchAlgorithmException
     */
    public static String generate(String source) throws NoSuchAlgorithmException{
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(source.getBytes(Charset.forName("UTF8")));
        final byte[] resultByte = messageDigest.digest();
        final String result = new String(Hex.encodeHex(resultByte));
        return result;
    }

}
