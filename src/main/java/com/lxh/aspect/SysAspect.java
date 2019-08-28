package com.lxh.aspect;

import com.lxh.annotation.Operation;
import com.lxh.entity.SysLog;
import com.lxh.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;
/**
 * Create By SINYA
 * Description:
 */
@Aspect
@Component
public class SysAspect {
 
    @Resource
    private LogService sysLogService;
 
    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation(com.lxh.annotation.Operation)")
    public void logPointCut(){
    }
 
    @AfterReturning("logPointCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        //保存日志
        SysLog sysLog = new SysLog();
 
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
 
 
        //获取操作
        Operation operation = method.getAnnotation(Operation.class);
        if (operation != null) {
            String value = operation.value();
            sysLog.setRequestDesc(value);//保存获取的操作
        }
 
        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
 
        //注入Syslog对象
        //username应从session里取出
        sysLog.setUserName("Sinya");
        
        //IP地址获取工具为HUtooljar包,自行添加依赖
        sysLog.setUserIp("192.168.10.99");
        sysLog.setRequestMethod(className + "." + methodName);
 
        //调用service保存SysLog实体类到数据库
        sysLogService.saveLog(sysLog);
    }
}