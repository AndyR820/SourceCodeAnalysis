package generic;

import java.io.Serializable;

/**
 * Created by andy on 2018/9/25.
 *
 */
public class GenericMethod {
    public static void main(String[] args) {

    }
        /**
         * 泛型方法的定义语法： 这里定义的就是一个泛型方法 方法的返回值类型是T，即任意的类型 返回值的具体类型由传入的类型参数来定
         *
         * @param <T>
         *            代表任意的类型
         * @param x
         * @param y
         * @return
         */
        private static <T> T add(T x, T y) {
            return null;
        }
        /**
         * 定义一个泛型方法来交换数组中指定索引位置的两个元素 这里传入的数组可以是任意类型的数组
         * 传入泛型方法的实际参数类型必须是引用类型的数组，不能是基本类型的数组
         *
         * @param <T>
         * @param a
         * @param i
         * @param j
         */
    private static <T> void swap(T[] a, int i, int j) {
        // 数组中元素位置未交换前的打印结果
        printArray(a);
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        System.out.println();
        printArray(a);
    }
    /**
     * 定义打印任意引用数组类型的方法
     *
     * @param <T>
     * @param array
     */
    private static <T> void printArray(T[] array) {
        for (T t : array) {
            System.out.print(t + "\t");
        }
    }
    /**
     * 定义有extends限定符，并且具有多个上边界的泛型方法，各个边界使用&符号分隔
     * @param <T>
     */
    public <T extends Serializable & Cloneable> void method(){

    }
}
