package system;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Created by andy on 2018/9/20.
 *
 * System Class
 */
public class SystemSC {


    /**
     * 获得当前工作目录
     * @return 当前工作目录
     */
    public static String getProperty(){
        return System.getProperty("user.dir");
    }

    /**
     * 数组拷贝
     * arraycopy方法五个参数，
     * 被复制的数组，被复制的起始位置，复制到的数组，复制到这个数组的起始位置，复制到这个数组的结束位置。
     * 这个方法和Arrays中的copyOf、copyOfRange比较像，参数比较多，如果有需要也可使用。
     */
    public static void arrayCopy(){
        int[] arr1 = { 0, 1, 2, 3, 4 };
        int[] arr2 = { 9, 9, 9, 9, 9 };
        System.arraycopy(arr1, 2, arr2, 0, 3);
        for(int i=0;i<arr2.length;i++){
            System.out.println(arr2[i]);
        }
    }

    /**
     * get毫秒数
     */
    public static long getcurrentTimeMillis(){
        return System.currentTimeMillis();
    }

    /**
     * 获取系统属性
     */
    public static void getPropertyCS(){
        //获取所有信息
        Properties p = System.getProperties();
        System.out.println(System.getProperties());
        //Java 运行时环境版本
        System.out.println(System.getProperty("java.version"));
        //Java运行时环境供应商
        System.out.println(System.getProperty("java.vendor"));
        //Java 供应商的 URL
        System.out.println(System.getProperty("java.vendor.url"));
        //Java 安装目录
        System.out.println(System.getProperty("java.home"));
        //Java 虚拟机规范版本
        System.out.println(System.getProperty("java.vm.specification.version"));
        //Java 虚拟机规范供应商
        System.out.println(System.getProperty("java.vm.specification.vendor"));
        //Java 虚拟机规范名称
        System.out.println(System.getProperty("java.vm.specification.name"));
        //Java 虚拟机实现版本
        System.out.println(System.getProperty("java.vm.version"));
        //Java 虚拟机实现供应商
        System.out.println(System.getProperty("java.vm.vendor"));
        //Java 虚拟机实现名称
        System.out.println("Java 虚拟机实现名称"+System.getProperty("java.vm.name"));
        //Java 运行时环境规范版本
        System.out.println(System.getProperty("java.specification.version"));
        //Java 运行时环境规范供应商
        System.out.println(System.getProperty("java.specification.vendor"));
        //Java 类格式版本号
        System.out.println(System.getProperty("java.class.version"));
        //Java 类路径
        System.out.println(System.getProperty("java.class.path"));
        //加载库时搜索的路径列表
        System.out.println(System.getProperty("java.library.path"));
        //默认的临时文件路径
        System.out.println(System.getProperty("java.io.tmpdir"));
        //要使用的 JIT 编译器的名称
        System.out.println(System.getProperty("javacompiler"));
        //一个或多个扩展目录的路径
        System.out.println(System.getProperty("java.ext.dirs"));
        //操作系统的名称
        System.out.println(System.getProperty("os.name"));
        //操作系统的架构
        System.out.println(System.getProperty("os.arch"));
        //操作系统的版本
        System.out.println(System.getProperty("os.version"));
        //文件分隔符（在 UNIX 系统中是“/”）
        System.out.println(System.getProperty("file.separator "));
        //路径分隔符（在 UNIX 系统中是“:”）
        System.out.println(System.getProperty("path.separator "));
        //行分隔符（在 UNIX 系统中是“/n”）
        System.out.println(System.getProperty("line.separator "));
        //用户的账户名称
        System.out.println(System.getProperty("user.name "));
//        用户的主目录
        System.out.println(System.getProperty("user.home"));
//        用户的当前工作目录
        System.out.println(System.getProperty("user.dir "));
//        获得当前开发环境的字符编码方式
        System.out.println(System.getProperty("file.encoding"));
    }


    /**
     * GC
     */
    public static void gcCS(){
        Date data=new Date();
        data=null;
        System.out.println("释放前"+data);
        System.gc();
        System.out.println("释放后"+data);
    }

    public static void main(String[] args) {
//        System.getProperty("user.dir");

//        getPropertyCS();
    }
}
