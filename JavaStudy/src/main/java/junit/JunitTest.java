package junit;

import junit.framework.TestCase;

public class JunitTest extends TestCase {
    private int count=0;
    public void test1(){
        count++;
        assertEquals(1,count);
    }
    public void test2(){
        count++;
        assertEquals(1,count);
    }
}
