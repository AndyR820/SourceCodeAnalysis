package testng.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.text.SimpleDateFormat;

/**
 * Test Listenner Class
 * Created by andy on 2018/9/11.
 */
public class CommonListener extends TestListenerAdapter {
    static final Logger logger = LogManager.getLogger(CommonListener.class);

    @Override
    public void onTestFailure(ITestResult testresult) {
        logger.info(" >> "+testresult.getName()+ " | Test Method Failed");
    }

    @Override
    public void onTestSkipped(ITestResult testresult) {
        logger.info(" >> "+testresult.getName()+ "| Test Method Skipped");
    }

    /**
     * Test Success
     * @param testresult
     */
    @Override
    public void onTestSuccess(ITestResult testresult) {
        logger.info(" >> "+testresult.getTestClass()+"-"+testresult.getName()+ "| Test Method Success");
    }


    /**
     * CASE Start
     * @param result
     */
    public void onTestStart(ITestResult result) {
        String time=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss:SS E").format(result.getStartMillis());
        logger.info( " >> "+result.getTestClass()+"."+result.getName()+" | Test Start ");
    }

    /**
     * Test Start
     * @param testContext
     */
    public void onStart(ITestContext testContext) {
        String time=new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss:SS E").format(testContext.getStartDate());
        logger.info( " >> "+testContext.getSuite().getName()+" | Start ");
    }

    /**
     * Test Finish
     * @param testContext
     */
    public void onFinish(ITestContext testContext) {
        logger.info( " >> "+testContext.getSuite().getName()+" | Finish");
//        log(testContext.getName()+"| testContext.getName() | Finish \n");
//        log(testContext.getSuite()+"| testContext.getSuite() | Finish \n");
//        log(testContext.getHost()+"| testContext.getHost() | Finish \n");
//        log(testContext.getOutputDirectory()+"| testContext.getOutputDirectory() | Finish \n");
//        log(testContext.getAllTestMethods()+"| testContext.getAllTestMethods() | Finish \n");
//        log(testContext.getCurrentXmlTest()+"| testContext.getCurrentXmlTest() | Finish \n");
//        log(testContext.getEndDate()+"| testContext.getEndDate() | Finish \n");
//        log(testContext.getExcludedGroups()+"| testContext.getExcludedGroups() | Finish \n");
//        log(testContext.getExcludedMethods()+"| testContext.getExcludedMethods() | Finish \n");
//        log(testContext.getPassedTests()+"| testContext.getPassedTests() | Finish \n");

    }

}
