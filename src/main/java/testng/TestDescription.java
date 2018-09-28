package testng;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by andy on 2018/9/25.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestDescription {

    //测试项
    public String item() default "aaa";
    //测试描述
    public String description() default "";
    //验证点
    public String verification() default "";

    public String CaseID() default"";
    public String Lever() default"";


}
