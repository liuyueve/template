package com.haizhi.template.config.jsonFormat.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Create by liuyu
 * Date is 2019-08-27
 * Description is : LocalDateTime序列化工具类
 */

public class LocalDateTimeSerializer implements ObjectSerializer {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static final LocalDateTimeSerializer instance = new LocalDateTimeSerializer();

    private LocalDateTimeSerializer(){}

    public LocalDateTimeSerializer(String pattern){
        this.formatter = DateTimeFormatter.ofPattern(pattern);
    }

    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if (o == null) {
            out.writeNull();
        } else if (o instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) o;
            out.writeString(formatter.format(localDateTime));
        } else {
            out.writeNull();
        }
    }
}
