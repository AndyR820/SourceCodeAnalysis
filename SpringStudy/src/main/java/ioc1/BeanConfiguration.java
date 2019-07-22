package ioc1;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public AccountDao accountDao(){
        return new AccountDaoImpl();
    }

    @Bean
    public AccountService accountService(){
        AccountServiceImpl bean=new AccountServiceImpl();
        //注入dao
        bean.setAccountDao(accountDao());
        return bean;
    }

    @Test
    public void testByConfigurationAnnotation() throws Exception {

        AnnotationConfigApplicationContext config=new AnnotationConfigApplicationContext(BeanConfiguration.class);
        //名称必须BeanConfiguration中工程方法名称一致
        AccountService accountService= (AccountService) config.getBean("accountService");
        accountService.doSomething();

    }
}
