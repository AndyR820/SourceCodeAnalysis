package testng.listener;

import org.testng.IMethodInstance;
import org.testng.ITestContext;
import org.testng.ITestNGListener;

import java.util.List;

/**
 * Created by andy on 2018/10/8.
 */
public interface listenerFilter extends ITestNGListener {
    List<IMethodInstance> intercept(List<IMethodInstance> var1, ITestContext var2);


}
