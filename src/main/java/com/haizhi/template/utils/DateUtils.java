package com.haizhi.template.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Create by liu·yu
 * Date is 2020-07-10
 * Description is : 时间处理工具类
 */
public class DateUtils {

    private static final ZoneId LOCAL_ZONE = ZoneId.of("Asia/Shanghai");

    private static final DateTimeFormatter FORMAT_RFC5322 = DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss z", Locale.US)
                                                                             .withZone(LOCAL_ZONE);

    public static String getFormat_RFC5322() {
        return LocalDateTime.now().format(FORMAT_RFC5322);
    }

}
