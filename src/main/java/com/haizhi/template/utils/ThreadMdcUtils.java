package com.haizhi.template.utils;

import com.haizhi.template.config.Constant;
import org.slf4j.MDC;

import java.util.Map;

/**
 * Create by liuyu
 * Date is 2019-05-22
 * Description is : 线程装饰器，用于@Async传递traceId
 */
public class ThreadMdcUtils {

    public static Runnable wrapAsync(Runnable task, Map<String,String> context){
        return () -> {
            if(context==null){
                MDC.clear();
            }else {
                MDC.setContextMap(context);
            }
            if(MDC.get(Constant.TraceId)==null){
                MDC.put(Constant.TraceId,UUIDUtils.randomUUID());
            }
            try {
                task.run();
            }finally {
                MDC.clear();
            }
        };
    }

    public static Runnable wrapSchedule(Runnable task){
        return ()->{
          MDC.put(Constant.TraceId,UUIDUtils.randomUUID());
          try {
              task.run();
          }finally {
              MDC.clear();
          }
        };
    }
}
