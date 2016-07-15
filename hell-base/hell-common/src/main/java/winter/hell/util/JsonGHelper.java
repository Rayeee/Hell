package winter.hell.util;

import com.google.gson.Gson;
import org.springframework.util.StringUtils;

public class JsonGHelper {
    private static final Gson gson = new Gson();

    public static String serialize(Object o) {
        return gson.toJson(o);
    }

    public static <T> T deserialize(String json,  Class<T> t) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return gson.fromJson(json, t);
    }
}

