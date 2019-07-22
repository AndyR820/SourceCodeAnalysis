package aop.jdkself;

import java.lang.reflect.Proxy;

/**
 * 例子演示的是在方法执行前织入一段记录日志的代码，其中
 *
 *     Business是代理类
 *     LogInvocationHandler是记录日志的切面
 *     IBusiness、IBusiness2是代理类的接口
 *     Proxy.newProxyInstance是织入器
 */
public class Test {
    public static void main(String[] args) {
        //需要代理的类接口，被代理类实现的多个接口都必须在这这里定义
        Class[] proxyInterface = new Class[]{IBusiness.class, IBusiness2.class};
        //构建AOP的Advice，这里需要传入业务类的实例
        LogInvocationHandler handler = new LogInvocationHandler(new Business());
        //生成代理类的字节码加载器
        ClassLoader classLoader = Business.class.getClassLoader();
        //织入器，织入代码并生成代理类
        IBusiness2 proxyBusiness = (IBusiness2) Proxy.newProxyInstance(classLoader, proxyInterface, handler);
        proxyBusiness.doSomeThing2();
        ((IBusiness) proxyBusiness).doSomeThing();
    }
}
