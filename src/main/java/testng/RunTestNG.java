package testng;

import org.testng.*;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;
import testsample.SampleTest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andy on 2018/10/8.
 */
public class RunTestNG {
    public static void  runTestNG(Class[] classes,String caseid){
        IMethodInterceptor t1 = new CaseFilterByAnnotation();
        IInvokedMethodListener t2=new ProgressTrackerListener();
        TestNG t = new TestNG();
        t.setTestClasses(classes);
        List<String> tests=new ArrayList<>();
        t.setMethodInterceptor(new CaseFilterByCaseId(caseid));
//        t.addListener(t1);
        t.addListener(t2);
        t.run();
    }

    public static void main(String[] args) {
        runTestNG( new Class[] {SampleTest.class},"rjjtest001");
        runTestNG( new Class[] {SampleTest.class},"rjjtest002");
//        XmlSuite suite = new XmlSuite();
//        suite.setName("BI.Suite");
//        XmlTest test = new XmlTest(suite);




    }


}
