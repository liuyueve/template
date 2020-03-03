# template for haizhi

## 模板特点

1. 内置启动停止脚本，方便部署
2. 整合swagger－ui，方便生出api文档，以及在苦户机进行简单接口测试
3. 整合简单链路追踪，可以满足单线程请求
4. 内置全局异常处理中心，方便处理rest请求的异常信息
5. 优化maven打包结构，将配置文件单独提出，方便修改

## 启动脚本参数含义

--spring.config.location=classpath:../env    指定服务配置文件夹为env

--spring.profiles.active=${env}         指定服务环境，默认情况为prod

--logging.path=../log/process_$((i+1))  指定日志文件夹

## jvm启动参数注释

java -XX:+PrintFlagsFinal -XX:+UnlockDiagnosticVMOptions -version 查看jvm所有启动参数

--gc相关

-XX:+UseG1GC 使用G1收集器

-XX:G1HeapRegionSize=4M 设置G1收集器分区大小

-Xmx4G 设置堆内存最大值

-Xms4G 设置堆内存初始化大小

-Xmn2G 设置堆内存年轻代大小

-XX:MetaspaceSize=64M 设置元数据区域最大值

-XX:MaxMetaspaceSize=64M 设置元数据区域初始化大小

-XX:PrintGCDetails 打印gc日志 -Xlog:gc*

-Xloggc:log.gc gc日志的位置 -Xlog:gc:gc.log 

-XX:+UseAdaptiveSizePolicy 使用动态内存分配


--编译相关

-Xint 强制以解释模式运行

-Xcomp 强制以编译模式运行

-XX:CompileThreshold=10 方法触发编译的值

-XX:-UseCounterDecay 禁用方法计数器半衰期

--其他

-XX:+HeapDumpOnOutOfMemoryError 内存溢出时dump出内存快照

-Dsun.reflect.noInflation=true 关闭反射调用 Inflation 机制，取消委派实现，直接采用动态实现






