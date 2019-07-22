package classone;

import java.util.HashMap;
import java.util.Map;

/**
 * 余弦相似度
 *
 */
public class Class1 {

    //分子
    public static double m0(double[] a,double[] b){
        return m1(a)*m1(b);
    }
    //求单个积
    public static double m1(double[] a){
        double sum=0;
        for(int i=0;i<a.length;i++){
            sum+=Math.pow(a[i],2);
        }
        return Math.sqrt(sum);
    }

    //分母
    public static double m2(double[] a,double[] b){
        double sum1=0;
        for(int i=0;i<a.length;i++){
            sum1+=a[i]*b[i];
        }
        return sum1;
    }

    //求值
    public static double result(double s1,double s2){
        return s2/s1;
    }

    public static void main(String[] args) {
        double[] a={1,1,2,1,1,1,0,0,0};
        double[] b={1,1,1,0,1,1,1,1,1};
        double s1=m0(a,b);
        double s2=m2(a,b);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(result(s1,s2));
        Map map=new HashMap();


    }
}
