package mockito;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class SimpleMockTest {

    @Test
    public void testSimple() {
        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);
        // 设置方法的预期返回值
        when(list.get(0)).thenReturn("hello mock");
        String result = list.get(0);
        //验证方法调用(是否调用了get(0))
        verify(list).get(0);
        //测试
        Assert.assertEquals("hello mock", result);
    }

    @Test
    public void testSimple1() {
        //创建mock对象，参数可以是类，也可以是接口
        List<String> list = mock(List.class);
        // 设置方法的预期返回值
        when(list.get(0)).thenReturn("hello mock");
        String result = list.get(0);
        //验证方法调用(是否调用了get(0))
        verify(list).get(0);
        //测试
        Assert.assertEquals("hello mock1", result);
    }


    }
