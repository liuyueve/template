package com.haizhi.template.config.jsonFormat.modifier;

import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.BeanSerializerModifier;
import com.haizhi.template.config.jsonFormat.serializer.NullArraySerializer;
import com.haizhi.template.config.jsonFormat.serializer.NullStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * Create by liuyu
 * Date is 2019-09-07
 * Description is : 自定义null值全局修饰器
 */
@Component
public class NullSerializerModifier extends BeanSerializerModifier {

    @Autowired
    private NullStringSerializer nullStringSerializer;

    @Autowired
    private NullArraySerializer nullArraySerializer;

    @Override
    public List<BeanPropertyWriter> changeProperties(SerializationConfig config, BeanDescription beanDesc, List<BeanPropertyWriter> beanProperties) {
        for (BeanPropertyWriter writer : beanProperties) {
            Class<?> rawClass = writer.getType().getRawClass();
            if(rawClass.isAssignableFrom(String.class)){
                writer.assignNullSerializer(nullStringSerializer);
            }else if(rawClass.isArray()||rawClass.isAssignableFrom(List.class)||rawClass.isAssignableFrom(Set.class)){
                writer.assignNullSerializer(nullArraySerializer);
            }
        }
        return beanProperties;
    }
}
