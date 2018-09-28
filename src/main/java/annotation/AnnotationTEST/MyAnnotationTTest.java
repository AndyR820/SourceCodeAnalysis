package annotation.AnnotationTEST;

/**
 * Created by andy on 2018/9/25.
 */

//只有一个Value需要赋值
//@MyAnnotationT(value="Andy")

//因为只有一个属性必需要赋值,可以去掉属性
//@MyAnnotationT("Andy")

//将所有属性赋值
@MyAnnotationT(
        color="red",
        value="Andy",
        arrayAttr={3,5,6},
        lamp=EumTrafficLamp.YELLO,
        annotationAttr=@MetaAnnotation("Andy")
)
public class MyAnnotationTTest {
    @MyAnnotationT("将MyAnnotation注解标注到main方法上")
     public static void main(String[] args) {
        if(MyAnnotationTTest.class.isAnnotationPresent(MyAnnotationT.class)){
            MyAnnotationT ant=(MyAnnotationT)MyAnnotationTTest.class.getAnnotation(MyAnnotationT.class);
            System.out.println(ant.color());
            System.out.println(ant.value());
            System.out.println(ant.arrayAttr());
            System.out.println(ant.lamp());
            System.out.println(ant.annotationAttr());
        }
    }

}
