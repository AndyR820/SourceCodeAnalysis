package annotation;

/**
 * Created by andy on 2018/9/25.
 */
public class RetentionPolicyRC {
    /**
     *  * @Retention(RetentionPolicy.SOURCE)
     * Annotations are to be discarded by the compiler.
     * 这个注解的意思是让Annotation注解只在java源文件中存在，编译成.class文件后注解就不存在了
     *
     */
//    SOURCE,

    /**
     *  * @Retention(RetentionPolicy.CLASS)

     * Annotations are to be recorded in the class file by the compiler
     * but need not be retained by the VM at run time.  This is the default
     * behavior.
     * 这个注解的意思是让MyAnnotation注解在java源文件(.java文件)中存在，编译成.class文件后注解也还存在
     * 被Annotation注解类标识的类被类加载器加载到内存中后MyAnnotation注解就不存在了
     *
     */
//    CLASS,

    /**
     * Annotations are to be recorded in the class file by the compiler and
     * retained by the VM at run time, so they may be read reflectively.
     *让MyAnnotation这个注解的生命周期一直程序运行时都存在
     * @see java.lang.reflect.AnnotatedElement
     */
//    RUNTIME
}
