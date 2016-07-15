package winter.hell.util;

import org.apache.commons.lang3.time.FastDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import winter.hell.exception.HellSystemException;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

public class ThreadSafeDateUtil {
    private static final Logger LOG = LoggerFactory.getLogger(ThreadSafeDateUtil.class);
    private static final FastDateFormat FAST_DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd");
    private static final FastDateFormat FAST_DATE_FORMAT_STRING_TO_DATE = FastDateFormat
            .getInstance("yyyy-MM-dd HH:mm:ss");
    private static final FastDateFormat FAST_DATE_FORMAT_TIGHT_STRING = FastDateFormat.getInstance("yyyyMMddHHmmss");
    private static final String ZERO = " 00:00:00";

    public static final Timestamp getStartOfDay(Timestamp timestamp) throws ParseException {
        return getStartOfDay(timestamp.getTime());
    }

    public static final String getStringOfCurrTime(long currTime) {
        return FAST_DATE_FORMAT_TIGHT_STRING.format(currTime);
    }

    public static final Timestamp getStartOfDay(long time) throws ParseException {
        String ymd = FAST_DATE_FORMAT.format(time);
        Date date = null;
        try {
            date = FAST_DATE_FORMAT_STRING_TO_DATE.parse(ymd + ZERO);
            LOG.info("传入时间为：{},输出时间为{}", new Timestamp(time), date);
        } catch (ParseException e) {
            LOG.error("传入时间为" + time);
            LOG.error("获取当天凌晨时间失败", e);
            throw e;
        }
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }


    /**
     * 获取前一天21点的timestamp
     *
     * @param time
     * @return
     */
    public static final Timestamp getStartFromCustomTimestamp(long time) throws ParseException {
        long threeHourTimeMillis = 3 * 60 * 60 * 1000;
        Timestamp timestamp = null;
        try {
            String ymd = FAST_DATE_FORMAT.format(time);
            Date date = FAST_DATE_FORMAT_STRING_TO_DATE.parse(ymd + ZERO);
            timestamp = new Timestamp(date.getTime() - threeHourTimeMillis);
            LOG.info("传入时间为：{},输出时间为{}", new Timestamp(time), timestamp);
        } catch (Exception e) {
            LOG.error("传入时间为" + time);
            LOG.error("获取当天凌晨时间失败", e);
            throw e;
        }
        return timestamp;
    }


}
