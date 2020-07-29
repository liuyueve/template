package com.haizhi.template.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Create by liu·yu
 * Date is 2020-07-10
 * Description is : 时间处理工具类
 */
public class DateUtils {

    /*
        定义一些时间类基本的工具，如时区，格式等
     */

    public static final ZoneId LOCAL_ZONE = ZoneId.of("Asia/Shanghai");

    public static final ZoneOffset LOCAL_ZONE_OFFSET = ZoneOffset.of("+8");

    public static final DateTimeFormatter FORMAT_RFC5322 = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)
                                                                            .withZone(LOCAL_ZONE);

    public static final DateTimeFormatter NORMAL_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(LOCAL_ZONE);

    public static final DateTimeFormatter NORMAL_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd").withZone(LOCAL_ZONE);

    public static final DateTimeFormatter NORMAL_TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(LOCAL_ZONE);

    //获取RFC5322格式时间字符串,添加响应头用
    public static String getRFC5322String() {
        return LocalDateTime.now().format(FORMAT_RFC5322);
    }

    /*
        第一类方法，获取格式化字符串
     */

    public static String getNormalString() {
        return LocalDateTime.now().format(NORMAL_DATE_TIME_FORMAT);
    }

    public static String getNormalString(LocalDateTime time) {
        return time.format(NORMAL_DATE_TIME_FORMAT);
    }

    public static String getNormalString(long timestamp) {
        return LocalDateTime.ofEpochSecond(timestamp / 1000, 0, LOCAL_ZONE_OFFSET).format(NORMAL_DATE_TIME_FORMAT);
    }

    /*
        第二类方法，获取时间戳
     */

    public static long getTimestampByString(String time) {
        return LocalDateTime.parse(time, NORMAL_DATE_TIME_FORMAT).toInstant(LOCAL_ZONE_OFFSET).toEpochMilli();
    }

    public static long getTimestampByTime(LocalDateTime time) {
        return time.toInstant(LOCAL_ZONE_OFFSET).toEpochMilli();
    }

    /*
        第三类方法，获取时间类
     */
    public static LocalDateTime getLocalDateTimeByString(String time) {
        return LocalDateTime.parse(time, NORMAL_DATE_TIME_FORMAT);
    }

    public static LocalDateTime getLocalDateTimeByTimeStamp(long time) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(time), LOCAL_ZONE);
    }

}
