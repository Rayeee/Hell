package winter.hell.redis.utils;

import me.ele.elog.Log;
import me.ele.elog.LogFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.StdSerializerProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhengwen
 *
 */
public class SerializeUtil {
    private static final Log logger = LogFactory.getLog(SerializeUtil.class);

    public static final ObjectMapper mapper = new ObjectMapper();
    static {
        StdSerializerProvider sp = new StdSerializerProvider();
        sp.setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(Object value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
                    JsonProcessingException {
                jgen.writeString("");// null 序列化为 ""

            }
        });

        mapper.setSerializerProvider(sp);
        mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * 序列化
     * 
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            // 序列化
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * 反序列化
     * 
     * @param bytes
     * @return
     */
    public static Object unserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            // 反序列化
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

    public static String beanToJson(Object o) throws JsonException {

        try {
            return mapper.writeValueAsString(o);
        } catch (Exception e) {
            logger.error("bean转json出错", e);
            throw new JsonException("系统异常", e);
        }

    }

    public static <T> T jsonToBean(String s, Class<T> clazz) throws JsonException {

        try {
            return mapper.readValue(s, clazz);
        } catch (Exception e) {
            logger.error("json转化为bean出错", e);
            throw new JsonException("系统异常", e);
        }

    }

    public static <T> List<T> getObjectsFromJson(String in, Class<T> clsT) throws IOException {

        JsonParser parser = mapper.getJsonFactory().createJsonParser(in);

        JsonNode nodes = parser.readValueAsTree();
        List<T> list = new ArrayList<T>(nodes.size());
        for (JsonNode node : nodes) {
            list.add(mapper.readValue(node, clsT));
        }
        return list;

    }

    public static Object deepClone(Object o) throws Exception {
        // 将对象写到流里
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo = new ObjectOutputStream(bo);
        oo.writeObject(o);
        // 从流里读出来
        ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
        ObjectInputStream oi = new ObjectInputStream(bi);
        return (oi.readObject());
    }
}
