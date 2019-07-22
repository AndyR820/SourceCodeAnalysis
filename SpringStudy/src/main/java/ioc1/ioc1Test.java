package ioc1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 默认查找classpath路径下的文件
 * ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/spring-ioc.xml");
 * 多文件,也可传递数组
 * ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring/spring-ioc.xml","spring/spring-ioc2.xml",.....);
 * 默认为项目工作路径 即项目的根目录
 * FileSystemXmlApplicationContext applicationContext=
 * new FileSystemXmlApplicationContext("/src/main/resources/spring/spring-ioc.xml");
 * 也可以读取classpath下的文件
 * FileSystemXmlApplicationContext applicationContext=new FileSystemXmlApplicationContext("classpath:spring/spring-ioc.xml");
 * 使用前缀file 表示的是文件的绝对路径
 * ApplicationContext applicationContext = new FileSystemXmlApplicationContext("file:D:/app.spring.xml");
 * 多文件与ClassPathXmlApplicationContext相同
 */

public class ioc1Test {
    @Test
    public void testByXml() throws Exception {
        //加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        //获取服务的方式一
//        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        //获取服务的方式二
        //多次获取并不会创建多个accountService对象,因为spring默认创建是单实例的作用域
        AccountService accountService= (AccountService) applicationContext.getBean("accountService");
        accountService.doSomething();
    }
    @Test
    public void testsetter(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        Account account= (Account) applicationContext.getBean("account");
        System.out.println(account.getName());
        System.out.println(account.getPwd());

    }
}
