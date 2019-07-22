package aop.jdkself;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {
    private Object target;//目标对象


    public LogInvocationHandler(Object target) {
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //执行织入的日志，你可以控制哪些方法执行切入逻辑
        if (method.getName().equals("doSomeThing2")) {
            System.out.println("doSomeThing2-记录日志");
        }else{
            System.out.println(method.getName()+"-记录日志");
        }
        //执行原有逻辑
        Object recv = method.invoke(target, args);
        return recv;    }
}
