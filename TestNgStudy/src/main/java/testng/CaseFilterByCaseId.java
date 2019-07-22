package testng;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by andy on 2018/9/26.
 */
public class CaseFilterByCaseId implements IMethodInterceptor {

    private List<IMethodInstance> methodsToTest = null;
    //不用执行的
    public static int totalIgnored = 0;
    public static int totalRun = 0;
    public static int totalConfigured = 0;
    private static String caseid;
    public CaseFilterByCaseId(String caseid){
        this.caseid=caseid;
    }


    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext iTestContext) {
        System.out.println("caseid"+caseid);
        if (methodsToTest == null) {
            //建立一个排序MAP
            SortedMap<String, IMethodInstance> sortedMap = new TreeMap<String, IMethodInstance>();
            //定义一个不满足条件的方法LIST
            List<String> ignoredMethods = new ArrayList<String>();
            //遍历所有的方法
            for (Iterator<IMethodInstance> it = methods.iterator(); it.hasNext(); ) {
                //将下一个方法赋值给变量
                IMethodInstance iMethodInstance = it.next();
                ITestNGMethod m = iMethodInstance.getMethod();
                String methodName = m.getConstructorOrMethod().getName();
                String className = m.getTestClass().getRealClass().getName();
                totalConfigured += 1;
                if (isQualified(iMethodInstance.getMethod())) {
                    String sortKey = className + "_" + methodName;
                    sortedMap.put(sortKey, iMethodInstance);
                    totalRun += 1;
                } else {
                    ignoredMethods.add(methodName + "(" + className + ")");
                    totalIgnored += 1;
                }
            }
            List<IMethodInstance> rtMethods = new ArrayList<IMethodInstance>(sortedMap.values());

            ProgressTrackerListener.totalRun = totalRun;

            System.out.println("忽略的方法: " + ignoredMethods);

            methodsToTest = rtMethods;
        }
        return methodsToTest;
    }

    //判断是否满足自定义级别
    private boolean isQualified(ITestNGMethod iTestNGMethod) {
        boolean isQualified = false;
        Method m = iTestNGMethod.getConstructorOrMethod().getMethod();
        if ((m.getAnnotation(TestDescription.class) == null)) {
            return isQualified;
        }else if (m.getAnnotation(TestDescription.class).CaseID() == null) {
            return isQualified;
        }else if (m.getAnnotation(TestDescription.class).CaseID().equals(caseid)) {
            isQualified=true;
            return isQualified;
        }
        return isQualified;
    }

    

}
