package com.haizhi.template.config.jsonFormat.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Create by liuyu
 * Date is 2019-08-27
 * Description is : LocalDate序列化工具类
 */
public class LocalDateSerializer implements ObjectSerializer {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static final LocalDateSerializer instance = new LocalDateSerializer();

    private LocalDateSerializer(){}

    public LocalDateSerializer(String format){
        this.formatter = DateTimeFormatter.ofPattern(format);
    }

    @Override
    public void write(JSONSerializer jsonSerializer, Object o, Object o1, Type type, int i) throws IOException {
        SerializeWriter out = jsonSerializer.out;
        if (o == null) {
            out.writeNull();
        } else if (o instanceof LocalDate) {
            LocalDate localDate = (LocalDate) o;
            out.writeString(formatter.format(localDate));
        } else {
            out.writeNull();
        }
    }

}
