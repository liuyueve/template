# template for haizhi

## 模板特点

1. 内置启动停止脚本，方便部署
2. 整合swagger－ui，方便生出api文档，以及在苦户机进行简单接口测试
3. 整合简单链路追踪，可以满足单线程请求
4. 内置全局异常处理中心，方便处理rest请求的异常信息
5. 优化maven打包结构，将配置文件单独提出，方便修改

## 启动脚本参数含义

--spring.config.location=file:../env    指定服务配置文件夹为env

--spring.profiles.active=${env}         指定服务环境，默认情况为prod

--logging.path=../log/process_$((i+1))  指定日志文件夹
