package testngdemo.testcase;

import org.testng.annotations.*;

/**
 * Created by andy on 2018/9/13.
 */
public class testngclassB {

    @BeforeSuite
    public void test0(){
        System.out.println("BeforeSuite2");


    }
    @AfterSuite
    public void test1(){
        System.out.println("AfterSuite2");


    }
    @BeforeTest
    public void test2(){
        System.out.println("BeforeTest2");


    }
    @AfterTest
    public void test3(){
        System.out.println("AfterTest2");


    }
    @BeforeGroups
//            (groups={"groupstest"})
    public void test4(){
        System.out.println("BeforeGroups2");


    }
    @AfterGroups
//            (groups={"groupstest"})
    public void test5(){
        System.out.println("AfterGroups2");


    }
    @BeforeClass
    public void test6(){
        System.out.println("BeforeClass2");


    }
    @AfterClass
    public void test7(){
        System.out.println("AfterClass2");


    }
    @BeforeMethod
    public void test8(){
        System.out.println("BeforeMethod2");


    }
    @AfterMethod
    public void test9(){
        System.out.println("AfterMethod2");


    }
    @Test
    public void testcasec(){
        System.out.println("Test2");

    }
    @Test
    public void testcased(){
        System.out.println("Test211");

    }
}
