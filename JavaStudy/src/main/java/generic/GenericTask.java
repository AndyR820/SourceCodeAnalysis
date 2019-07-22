package generic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

/**
1.限定通配符?的上边界
正确的写法：Vector<? extends Number> x = new Vector<Integer>();
这里指的是?所代表的参数化类型必须是继承Number类的，如这里的?所代表的Integer类型就是继承Number类的
错误的写法：Vector<? extends Number> x = new Vector<String>();
2.限定通配符?的下边界
正确的写法：Vector<? super Integer> y = new Vector<Number>();
这里指的是?所代表的参数化类型必须是Integer类的父类，如这里的?所代表的Number类型就是Integer类的父类
错误的写法：Vector<? super Integer> y = new Vector<Byte>();
 * Created by andy on 2018/9/25.
 */
public class GenericTask {

    public static void main(String[] args) {
        Vector<? extends Number> x = new Vector<Integer>();
        Vector<? super Integer> y = new Vector<Number>();
    }
    /**
     * 1.编写一个泛型方法，自动将Object类型对象转换为其他类型
     * @param <T>
     * @param obj
     * @return
     */
    private static <T> T autoConvert(Object obj){
        return (T)obj;
    }
    /**
     * 2.定义一个泛型方法，可以将任意类型的数组中的所有元素填充为相应类型的某个对象
     * @param <T>
     * @param array
     * @param obj
     */
    private static <T> void fillArray(T[] array,T obj){
        for(int i=0;i<array.length;i++){
            array[i]=obj;
        }
        printArray(array);
    }
    /**
     * 3.采用自定泛型方法的方式打印出任意参数化类型的集合中的所有内容
     * @param <T>
     * @param collection
     */
    private static <T> void printCollection(Collection<T> collection){
        System.out.println(collection.size());
        for(Object obj:collection){
            System.out.println(obj);
        }
    }
    /**
     * 4.定义一个泛型方法，把任意参数类型的集合中的数据安全地复制到相应类型的数组中
     * @param <T>
     * @param srcCollection
     * @param descArray
     */
    private static <T> void CollectionCopyToarray(Collection<T> srcCollection,T[] descArray){
        Iterator<T> it = srcCollection.iterator();
        int recordElementPostion=0;
        while(it.hasNext()){
            descArray[recordElementPostion]=it.next();
            recordElementPostion++;
        }
        printArray(descArray);
    }
    /**
     * 5.定义一个泛型方法，把任意参数类型的一个数组中的数据安全地复制到相应类型的另一个数组中去
     * @param <T>
     * @param srcArray
     * @param descArray
     */
    private static <T> void srcArrayToDescArray(T[] srcArray,T[] descArray){
        for(int i=0;i<srcArray.length;i++){
            descArray[i]=srcArray[i];
        }
        printArray(descArray);
    }
    private static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.print(t + "\t");
        }
    }
}
