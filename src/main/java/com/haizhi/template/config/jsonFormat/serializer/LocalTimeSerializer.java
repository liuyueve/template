package com.haizhi.template.config.jsonFormat.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Create by liuyu
 * Date is 2019-08-27
 * Description is : LocalTime序列化工具类
 */
public class LocalTimeSerializer implements ObjectSerializer {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static final LocalTimeSerializer instance = new LocalTimeSerializer();

    private LocalTimeSerializer(){}

    public LocalTimeSerializer(String format){
        this.formatter = DateTimeFormatter.ofPattern(format);
    }

    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if (o == null) {
            out.writeNull();
        } else if (o instanceof LocalTime) {
            LocalTime localTime = (LocalTime) o;
            out.writeString(formatter.format(localTime));
        } else {
            out.writeNull();
        }
    }

}
