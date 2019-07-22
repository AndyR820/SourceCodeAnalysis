package generic;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by andy on 2018/9/25.
 */
public class GenericCase {

    public static void main(String[] args) {
        HashMap<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("lhm", 35);
        maps.put("flx", 33);
        /**
         * 变量的命名技巧：如果以后不知道一个变量该如何命名，就可以以方法名的形式来命名，
         * 如果要定义变量接收返回值，如果此时不知道如何定义变量名时，就直接定义成returnValue
         */
        Set<Map.Entry<String, Integer>> entrySet = maps.entrySet();// 这里的变量名直接以方法名的形式定义
        // 使用增强的for循环迭代Map容器中的key和value
        //这里的Entry是Map类的一个内部类，map类中存储的key和value都是封装在这个Entry内部类中的
        //这个Entry内部类提供了getKey方法取出键，getValue方法取出值
        for (Map.Entry<String, Integer> entry : entrySet) {
            System.out.println(entry.getKey() + "：" + entry.getValue());
        }

    }
}
