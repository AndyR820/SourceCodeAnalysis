package testng.listener;

import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Test Listenner Class
 * Created by andy on 2018/9/11.
 */
@Slf4j
public class CommonListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(ITestResult testresult) {
        log.info(" >> "+testresult.getName()+ " | Test Method Failed");
    }

    @Override
    public void onTestSkipped(ITestResult testresult) {
        log.info(" >> "+testresult.getName()+ "| Test Method Skipped");
    }

    /**
     * Test Success
     * @param testresult
     */
    @Override
    public void onTestSuccess(ITestResult testresult) {
        log.info(" >> "+testresult.getTestClass()+"-"+testresult.getName()+ "| Test Method Success");
    }


    /**
     * CASE Start
     * @param result
     */
    public void onTestStart(ITestResult result) {
        String time=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss:SS E").format(result.getStartMillis());
        log.info( " >> "+result.getTestClass()+"."+result.getName()+" | Test Start ");
    }

    /**
     * Test Start
     * @param testContext
     */
    public void onStart(ITestContext testContext) {
        String time=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss:SS E").format(testContext.getStartDate());
        log.info( " >> "+testContext.getSuite().getName()+" | Start ");
    }

    /**
     * Test Finish
     * @param testContext
     */
    public void onFinish(ITestContext testContext) {
        log.info( " >> "+testContext.getSuite().getName()+" | Finish");
//        TestNGlog(testContext.getName()+"| testContext.getName() | Finish \n");
//        TestNGlog(testContext.getSuite()+"| testContext.getSuite() | Finish \n");
//        TestNGlog(testContext.getHost()+"| testContext.getHost() | Finish \n");
//        TestNGlog(testContext.getOutputDirectory()+"| testContext.getOutputDirectory() | Finish \n");
//        TestNGlog(testContext.getAllTestMethods()+"| testContext.getAllTestMethods() | Finish \n");
//        TestNGlog(testContext.getCurrentXmlTest()+"| testContext.getCurrentXmlTest() | Finish \n");
//        TestNGlog(testContext.getEndDate()+"| testContext.getEndDate() | Finish \n");
//        TestNGlog(testContext.getExcludedGroups()+"| testContext.getExcludedGroups() | Finish \n");
//        TestNGlog(testContext.getExcludedMethods()+"| testContext.getExcludedMethods() | Finish \n");
//        TestNGlog(testContext.getPassedTests()+"| testContext.getPassedTests() | Finish \n");

    }

}
