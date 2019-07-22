package mockito;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MockStubbing {

    @Test
    public void testMockStubbing() {
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

        // 连续stubbing
        when(mockedList.get(0)).thenReturn("first").thenReturn("second").thenReturn("Third");

        // following prints "first"
//        System.out.println(mockedList.get(0));

        // following throws runtime exception
//        System.out.println(mockedList.get(1));

        // following prints "null" because get(999) was not stubbed
        // 默认情况下，对于所有有返回值且没有stub过的方法，mockito会返回相应的默认值。
        // 对于内置类型会返回默认值，如int会返回0，布尔值返回false。对于其他type会返回null。
//        System.out.println(mockedList.get(999));

//        // Although it is possible to verify a stubbed invocation, usually it's just redundant
//        // If your code cares what get(0) returns, then something else breaks (often even before verify() gets
//        // executed).
//        // If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
//        verify(mockedList).get(0);
//
//        // 重复stub两次,则以第二次为准。如下将返回"second"：
//        when(mockedList.get(0)).thenReturn("first");
//        when(mockedList.get(0)).thenReturn("second");
//
//        // 如果是下面这种形式，则表示第一次调用时返回“first”，第二次调用时返回“second”。可以写n多个.
//        when(mockedList.get(0)).thenReturn("first").thenReturn("second");
//        // 但是，如果实际调用的次数超过了stub过的次数，则会一直返回最后一次stub的值。
//        // 如上例，第三次调用get(0)时，则会返回"second".

        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));
        System.out.println(mockedList.get(0));




    }


}
