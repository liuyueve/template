package com.haizhi.template.config.jsonFormat.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Create by liuyu
 * Date is 2019-09-07
 * Description is : fastJson 自定义null String 处理器
 */
@Component
public class NullStringSerializer extends StdSerializer<Object> {

    public NullStringSerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString("");
    }
}
