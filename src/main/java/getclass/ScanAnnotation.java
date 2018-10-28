package getclass;

import testng.TestDescription;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by andy on 2018/9/28.
 * 扫描指定包的注解
 */
public class ScanAnnotation {
        /**
         * 查询指定包中的类的所有注解
         * @param packagePath 指定包路径
         * @param annotation 需要查询的注解
         * @param checkRepeat 是否查重
         * @return 注解集合
         * @throws Exception 如果有两个方法上的两个注解完全相同时则抛出异常
         */
        public static List<KeepAnnotation> getAnnotationByPackage(String packagePath
                , Class<? extends Annotation> annotation
                , boolean checkRepeat) throws Exception {

            Set<Class<?>> classes = ScanPack.getClasses(packagePath);
            List<KeepAnnotation> keepAnnotations = new ArrayList<>(classes.size());

            for (Class classzz : classes) {
                KeepAnnotation keepAnnotation = getAnnotationByClass(classzz, annotation, checkRepeat);
                keepAnnotations.add(keepAnnotation);
            }
            return keepAnnotations;
        }

        /**
         * 查找一个类上的所有注解
         *
         * @param classzz     指定查找的类
         * @param annotation  需要获取的注解
         * @param checkRepeat 是否查找重复的注解
         * @return 注解集合
         * @throws Exception 如果有两个方法上的两个注解完全相同时则抛出异常
         */
        public static KeepAnnotation getAnnotationByClass(Class<?> classzz
                , Class<? extends Annotation> annotation
                , boolean checkRepeat) throws Exception {

            KeepAnnotation KeepAnnotation = new KeepAnnotation(classzz);

            // 获取到类上的注解
            Annotation classzzAnnotation = classzz.getAnnotation(annotation);
            if (classzzAnnotation != null) KeepAnnotation.setClasszzAnnotation(classzzAnnotation);

            // 获取到方法上的注解
            Map<String,Annotation> methodAnnotations = new HashMap<>();
            Method[] methods = classzz.getMethods();
            for (Method method : methods) {
                Annotation methodAnnotation = method.getAnnotation(annotation);
                if (methodAnnotation != null) {
                    // 如果需要检查重复则检查否则不检测注解值是否重复
                    if (checkRepeat && methodAnnotations.containsValue(methodAnnotation))
                        throw new Exception(classzz.getName() + " \n" + method.getName() + " \n"
                                + methodAnnotation.toString() + " have repeat value");
                    else {
                        methodAnnotations.put(method.getName(),methodAnnotation);
                    }
                }
            }
            KeepAnnotation.setMethodAnnotation(methodAnnotations);
            return KeepAnnotation;
        }


        public static void main(String[] args) throws Exception {
             Set<Class<?>> classes = ScanPack.getClasses("");
//            KeepAnnotation KeepAnnotation = getAnnotationByClass(SampleTest.class, TestDescription.class, false);
//            System.out.println(KeepAnnotation);
            List<KeepAnnotation> k1=getAnnotationByPackage("",TestDescription.class,false);
            System.out.println(k1);
            for(int i=0;i<k1.size();i++){
                KeepAnnotation ka=k1.get(i);
                if((!ka.getMethodAnnotation().toString().equals("")) || ka.getMethodAnnotation()!=null){
                    System.out.println(ka.getClasszz().getName()+"~~~"+ka.getMethodAnnotation().toString());

                }
            }


        }
}
