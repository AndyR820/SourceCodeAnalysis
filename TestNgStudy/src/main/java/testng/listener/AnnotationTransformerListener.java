package testng.listener;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

public class AnnotationTransformerListener implements IAnnotationTransformer, IMethodInterceptor, IInvokedMethodListener {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

    }

    @Override
    public List<IMethodInstance> intercept(List <IMethodInstance> list, ITestContext iTestContext) {
        return null;
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }
}
