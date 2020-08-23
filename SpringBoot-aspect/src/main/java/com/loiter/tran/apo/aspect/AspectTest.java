package com.loiter.tran.apo.aspect;

import com.loiter.tran.apo.pojo.Employee;
import com.loiter.tran.apo.result.ResultBody;
import com.loiter.tran.beans.User;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

@Aspect
@Component
public class AspectTest {

    @Pointcut("execution(public * com.loiter.tran.apo.web.*.*(..))")
    public void doOperation() {}

    /**
     * @Title: before
     * @Description: 前置通知处理方法
     *    在处理之前调用，比如参数、权限校验
     * @param joinPoint
     */
    @Before("doOperation()")
    public void before(JoinPoint joinPoint) throws Throwable{
        Object[] objs = joinPoint.getArgs();
        System.out.println(">>>>" + objs);
        for (Object obj : objs) {
            if(obj instanceof User) {
                User user = (User) obj;
                System.out.println("before paramer is :" + user);
                String name = base64DeStr(user.getName());
                user.setName(name);
            }else if(obj instanceof Employee) {
                Employee employee = (Employee)obj;
                String name = base64DeStr(employee.getName());
                employee.setName(name);
            }
        }
    }

    @AfterReturning(returning = "object", pointcut = "doOperation()")
    public void doAfterReturning(Object object) {
        ResultBody resultBody = (ResultBody) object;
        String str =null;
        try {
            System.out.println(resultBody.getResult());
            str=base64EnStr(resultBody.getResult());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        resultBody.setCode("000000");
        resultBody.setResult(str);
        System.out.println("后通知响应的参数:"+resultBody);
    }

    public  String base64EnStr(String str) throws UnsupportedEncodingException {
        return Base64.getMimeEncoder().encodeToString(str.getBytes("UTF-8"));
    }


    public static String base64DeStr(String encodeStr) throws UnsupportedEncodingException {
        System.out.println("encodeStr is " + encodeStr);
//        byte[] decodeStr = Base64.getMimeDecoder().decode(encodeStr);
//        System.out.println(">>>>" + decodeStr);
//        String tempStr = new String(decodeStr, "UTF-8");
//        System.out.println("tempStr is " + tempStr);
        return encodeStr + "OK";
    }
}
