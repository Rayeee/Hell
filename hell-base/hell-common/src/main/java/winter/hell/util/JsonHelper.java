/**
 * 
 */
package winter.hell.util;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import winter.hell.exception.HellSystemException;
import winter.hell.exception.JsonExceptionCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hongtao
 *
 */
public final class JsonHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonHelper.class);

	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * 将一个对象，转换为json
	 * 
	 * @param obj
	 * @return
	 */
	public static String transObjToJsonString(Object obj) {
		String str;
		try {
			str = mapper.writeValueAsString(obj);
			return str;
		} catch (IOException e) {
			LOGGER.error("json转换失败,转换的源对象为{}", obj);
		}
		return "";// return 空字符串是为了保证调用方的safety
	}

	/**
	 * Json转换为对象
	 * 
	 * @param json
	 * @param cla
	 * @return
	 */
	public static <T> T transJsonStringToObj(String json, Class<T> cla) {
		try {
			T t = mapper.readValue(json, cla);
			return t;
		} catch (IOException e) {
			LOGGER.error("json转换失败", e);
		}
		return null;
	}

	public static<T> List<T> toObjectList(String json, Class<T> objectClass) throws HellSystemException {
		if(StringUtils.isEmpty(json)){
			return null;
		}

		try {
			List<T> result = new ArrayList<T>();
			JsonNode listNode = mapper.readTree(json);
			for(JsonNode objNode : listNode){
				T t = mapper.convertValue(objNode, objectClass);
				result.add(t);
			}
			return result;
		} catch (JsonParseException | UnrecognizedPropertyException ex) {
			LOGGER.error("JSON解析为[" + ClassUtils.getShortClassName(objectClass) + "]出错!", ex);
			throw new HellSystemException(JsonExceptionCode.JSON_PARSE_ERROR);
		} catch (IOException e) {
			LOGGER.error("json转换失败", e);
			throw new HellSystemException(JsonExceptionCode.JSON_PARSE_ERROR);
		}
	}
}
