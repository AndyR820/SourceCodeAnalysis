package factory;

import org.testng.annotations.Factory;

public class TestngFactory {

    @Factory
    public Object[] createInstances() {
        Object[] result = new Object[10];
        for (int i = 0; i < 10; i++) {
            result[i] = new TestngFactoryTest(i * 10);
        }
        return result;
    }
}
