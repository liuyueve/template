package com.haizhi.template.config.interceptor.formatter;

import com.haizhi.template.utils.DateUtils;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 * Create by liu·yu
 * Date is 2020-07-28
 * Description is : LocalDateTime格式化工具
 * @see com.haizhi.template.config.interceptor.GlobalWebMvcConfigurer#addFormatters
 */
public class LocalDateTimeFormatter implements Formatter<LocalDateTime> {
    @Override
    public LocalDateTime parse(String text, Locale locale) throws ParseException {
        return DateUtils.getLocalDateTimeByString(text);
    }

    @Override
    public String print(LocalDateTime object, Locale locale) {
        return DateUtils.getNormalString(object);
    }
}
