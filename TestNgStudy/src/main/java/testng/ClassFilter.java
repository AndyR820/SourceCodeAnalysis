package testng;



/**
 * Created by andy on 2018/9/28.
 */
public class ClassFilter {
    private static final String FILE_TYPE = "file";
    private static final String JAR_TYPE = "jar";

    /**
     * 获取当前线程加载器
     * @return
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }






}
