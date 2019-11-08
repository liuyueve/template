package com.haizhi.template.config.jsonFormat.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Create by liuyu
 * Date is 2019-09-07
 * Description is :
 */
@Component
public class NullArraySerializer extends StdSerializer<Object> {

    private NullArraySerializer() {
        super(Object.class);
    }

    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartArray();
        gen.writeEndArray();
    }
}
