package classone;

import java.util.HashMap;
import java.util.Map;

public class Class2 {

    /**
     * 余弦相似度
     */
    //分子
    public static double m0(double[] a, double[] b) {
        return m1(a) * m1(b);
    }

    //求单个积
    public static double m1(double[] a) {
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += Math.pow(a[i], 2);
        }
        return Math.sqrt(sum);
    }

    //分母
    public static double m2(double[] a, double[] b) {
        double sum1 = 0;
        for (int i = 0; i < a.length; i++) {
            sum1 += a[i] * b[i];
        }
        return sum1;
    }

    //求值
    public static double result(double[] a, double[] b) {

        System.out.println(m2(a, b));
        System.out.println(m0(a, b));
        return m2(a, b) / m0(a, b);

    }

    public static void main(String[] args) {

        String s = "我是中国人";
        String s1 = "我是外国人";
        System.out.println(result(getarr(s),getarr(s1)));

    }

    //拆词在字典中找KEY 返回向量
    public static double[] getarr(String s) {
        Map map0 = new HashMap();
        map0.put("我", 1);
        map0.put("是", 2);
        map0.put("中国", -30);
        map0.put("外国", 30);
        map0.put("人", 3);

        String[] cs = splite(s);
        double[] arr = new double[cs.length];
        String strs = "";
        for (int i = 0; i < cs.length; i++) {
            strs += cs[i];
            if (map0.get(strs) == null) {
                arr[i] = 0;
            } else {
                arr[i]= Double.parseDouble(map0.get(strs)+"");
                strs = "";
            }
        }
            return arr;
    }


    //拆词
    public static String[] splite(String str) {
        char[] arr = str.toCharArray();
        String[] arr1 = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = String.valueOf(arr[i]);
        }
        return arr1;
    }

}
