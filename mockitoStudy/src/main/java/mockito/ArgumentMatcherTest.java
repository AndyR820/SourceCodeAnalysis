package mockito;

import org.mockito.ArgumentMatcher;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ArgumentMatcherTest {
//    anyBoolean()
//    isNull()
//    anyList()
//    booleanThat()
//    isA(): //Object argument that implements the given class.
//    eq(boolean value): //boolean argument that is equal to the given value
//    endsWith(String suffix)
//    same(T value)
@Test
public void testArgumentMatcher1() {
    List mockedList = mock(List.class);
    when(mockedList.get(anyInt())).thenReturn("element");

}

    @Test
    public void testArgumentMatcher() {
        List mockedList = mock(List.class);
        when(mockedList.get(anyInt())).thenReturn("element");
        when(mockedList.contains(argThat(new MyMatcher()))).thenReturn(true);
        System.out.println(mockedList.contains("element"));
        System.out.println(mockedList.get(999));
        System.out.println(verify(mockedList).get(anyInt()));
        // verify(mockedList).add(someString -> someString.length() > 5);
        File mock = mock(File.class); // 首先mock File类。
        // 注意new AnyFiles()并不是一个matcher，需要调用argThat(new IsAnyFiles()))才返回一个matcher。
        // 下句中stub：当调用renameTo方法时，返回false。该方法参数可以是任意file对象。
        when(mock.renameTo(argThat(new AnyFiles()))).thenReturn(true);
        System.out.println(mock.renameTo(new File("test")));

        // 下句verify renameTo方法被调用了一次，同时输入参数是任意file。
        verify(mock).renameTo(argThat(new AnyFiles()));
    }

    class MyMatcher implements ArgumentMatcher <Object> {
        public boolean matches(Object argument) {
            if (argument != null && "element".equals(argument.toString())) {
                return true;
            }
            return false;
        }
    }

    class AnyFiles implements ArgumentMatcher <File> {
        @Override
        public boolean matches(File file) {
            return file.getClass() == File.class;
        }
    }



}
