package testngdemo.testcase;

import org.testng.annotations.*;

/**
 * Created by andy on 2018/9/13.
 */
public class testngclassA {

    @BeforeSuite
    public void test0(){
        System.out.println("BeforeSuite");


    }
    @AfterSuite
    public void test1(){
        System.out.println("AfterSuite");


    }
    @BeforeTest
    public void test2(){
        System.out.println("BeforeTest");


    }
    @AfterTest
    public void test3(){
        System.out.println("AfterTest");


    }
    @BeforeGroups
//            (groups={"groupstest"})
    public void test4(){
        System.out.println("BeforeGroups");


    }
    @AfterGroups
//            (groups={"groupstest"})
    public void test5(){
        System.out.println("AfterGroups");


    }
    @BeforeClass
    public void test6(){
        System.out.println("BeforeClass");


    }
    @AfterClass
    public void test7(){
        System.out.println("AfterClass");


    }
    @BeforeMethod
    public void test8(){
        System.out.println("BeforeMethod");


    }
    @AfterMethod
    public void test9(){
        System.out.println("AfterMethod");


    }
    @Test
    @Parameters({"name","sex"})
    public void testcaseA(String name, String sex){
        System.out.println(name+sex);
    }

    @Test(dataProvider = "params")
    public void testcaseB(String str, int i){
        System.out.println(str+i);

    }
    @DataProvider(name = "params")
    public Object [][] dataProvider(){
        return new Object[][]{
                {"A", 65},
                {"B", 66},
                {"C", 67}
        };
    }


}
