package generic;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * Created by andy on 2018/9/25.
 */
public class GenericTest {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /**
         * 使用泛型限定ArrayList容器只能存储字符串类型的对象
         */
        ArrayList<String> collection2 = new ArrayList<String>();
        //    collection2.add("孤傲苍狼");
        //collection2.add(1);//报错，因为限制了collection2只能存储String类的对象，不能加入Integer类型的对象
        //collection2.add(1L);//报错，因为限制了collection2只能存储String类的对象，不能加入Long类型的对象
        //由于已经指明集合中存储的是字符串类型的对象，因此这里不用再强制转型了
//        String element = collection2.get(0);
        ArrayList<Integer> collection3 = new ArrayList<Integer>();
        //对于参数化的泛型类型，getClass()方法的返回值和原始类型完全一样
        System.out.println(collection3.getClass());//结果为：java.util.ArrayList
        System.out.println(collection3.getClass() == collection2.getClass());//结果为true
        //使用反射得到集合，然后调用add方法往原本只能存储Integer对象的集合中存储一个String类型的对象
        collection3.getClass().getMethod("add", Object.class).invoke(collection3, "abc");
        System.out.println(collection3.get(0));//输出的结果为：abc，这证明字符串对象确实是存储到了原本只能存储Integer对象的集合中
    }
    /**
     * Collection<Object>中的Object只是说明Collection<Object>实例对象中的方法接收的参数是Object
     * Collection<Object>是一种具体的类型，new HashSet<Date>也是一种具体的类型，两者没有兼容性问题
     * @param collection
     */

    Collection c = new Vector<String>();
    public static void printCollection(Collection<?> collection){
        for(Object obj:collection){
            System.out.println(obj);
        }
        collection.size();//不报错，此方法与参数类型没有关系
        collection=new HashSet<Date>();//会报告错误
    }

}
